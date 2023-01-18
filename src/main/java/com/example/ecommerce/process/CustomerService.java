package com.example.ecommerce.process;

import com.example.ecommerce.db.bean.Customer;
import com.example.ecommerce.db.bean.CustomerExample;
import com.example.ecommerce.db.mapper.CustomerMapper;
import com.example.ecommerce.exception.SignUpException;
import com.example.ecommerce.util.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@RequiredArgsConstructor
public class CustomerService implements UserOperations{
    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider tokenProvider;

    private final CustomerMapper customerMapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean existsByEmail(String email) {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andEmailEqualTo(email);
        return customerMapper.countByExample(customerExample) > 0;
    }

    @Override
    public String signIn(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return tokenProvider.generateToken(authentication);
    }

    @Override
    public void signUp(String name, String email, String password, String address) {
        if(existsByEmail(email)){
            throw new SignUpException("Email already exists");
        }

        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPassword(bCryptPasswordEncoder.encode(password));
        customer.setAddress(address);

        customerMapper.insertSelective(customer);
    }
}
