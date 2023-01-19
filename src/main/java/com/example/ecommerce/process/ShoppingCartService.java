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

        Cart cart = findCartByCustomerIdAndProductId(customerId, productId);
        if(cart == null) {
            cart = new Cart();
            cart.setCustomerId(customerId);
            cart.setProductId(productId);
            cart.setQuantity(quantity);
            cartMapper.insert(cart);
        }else{
            if(cart.getQuantity() + quantity > product.getQuantity()){
                throw new AddToCartException("Not enough quantity");
            }
            cart.setQuantity(cart.getQuantity() + quantity);
            cartMapper.updateByPrimaryKey(cart);
        }
    }

    @Override
    public void removeFromCart(Long customerId, Long productId) {
        CartExample cartExample = new CartExample();
        cartExample.createCriteria().andCustomerIdEqualTo(customerId).andProductIdEqualTo(productId);
        cartMapper.deleteByExample(cartExample);
    }

    @Override
    public void clearCart(Long customerId) {
        CartExample cartExample = new CartExample();
        cartExample.createCriteria().andCustomerIdEqualTo(customerId);
        cartMapper.deleteByExample(cartExample);
    }

    private Cart findCartByCustomerIdAndProductId(Long customerId, Long productId){
        CartExample cartExample = new CartExample();
        cartExample.createCriteria().andCustomerIdEqualTo(customerId).andProductIdEqualTo(productId);
        List<Cart> cartList = cartMapper.selectByExample(cartExample);
        return cartList.stream().findFirst().orElse(null);
    }
}
