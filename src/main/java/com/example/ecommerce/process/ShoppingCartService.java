package com.example.ecommerce.process;

import com.example.ecommerce.db.bean.Cart;
import com.example.ecommerce.db.bean.CartExample;
import com.example.ecommerce.db.bean.Product;
import com.example.ecommerce.db.mapper.CartMapper;
import com.example.ecommerce.db.mapper.ProductMapper;
import com.example.ecommerce.exception.AddToCartException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingCartService implements CartOperations {
    private final ProductMapper productMapper;

    private final CartMapper cartMapper;

    @Override
    public void addToCart(Long customerId,Long productId, int quantity) {
        Product product = productMapper.selectByPrimaryKey(productId);
        if (product == null) {
            throw new AddToCartException("Product not found");
        }

        if(quantity > product.getQuantity()){
            throw new AddToCartException("Not enough quantity");
        }

        List<Cart> cartList = findCartByCustomerId(customerId);

        cartList.stream().filter(cart -> cart.getProductId().equals(productId)).findFirst().ifPresentOrElse(cart -> {
            cart.setQuantity(cart.getQuantity() + quantity);
            cartMapper.updateByPrimaryKey(cart);
        }, () -> {
            Cart cart = new Cart();
            cart.setCustomerId(customerId);
            cart.setProductId(productId);
            cart.setQuantity(quantity);
            cartMapper.insert(cart);
        });
    }

    private List<Cart> findCartByCustomerId(Long customerId){
        CartExample cartExample = new CartExample();
        cartExample.createCriteria().andCustomerIdEqualTo(customerId);
        return cartMapper.selectByExample(cartExample);
    }
}
