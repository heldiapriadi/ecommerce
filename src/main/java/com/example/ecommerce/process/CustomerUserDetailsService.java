package com.example.ecommerce.process;

import com.example.ecommerce.db.bean.Customer;
import com.example.ecommerce.db.bean.CustomerExample;
import com.example.ecommerce.db.mapper.CustomerMapper;
import com.example.ecommerce.model.UserCustomer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {
    private final CustomerMapper customerMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andEmailEqualTo(email);
        List<Customer> customer = customerMapper.selectByExample(customerExample);
        if (customer.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserCustomer(customer.get(0));
    }
}
