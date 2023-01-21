package com.example.ecommerce.process;

import com.example.ecommerce.db.bean.Cart;
import com.example.ecommerce.db.bean.CartExample;
import com.example.ecommerce.db.bean.Product;
import com.example.ecommerce.db.custom.bean.ProductCart;
import com.example.ecommerce.db.custom.mapper.CartProductMapper;
import com.example.ecommerce.db.mapper.CartMapper;
import com.example.ecommerce.db.mapper.ProductMapper;
import com.example.ecommerce.exception.AddToCartException;
import com.example.ecommerce.response.ProductCartResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShoppingCartService implements CartOperations {
    private final ProductMapper productMapper;

    private final CartMapper cartMapper;

    private final CartProductMapper cartProductMapper;

    @Override
    public void addToCart(Long customerId,Long productId, int quantity) {
        log.info("addToCart start customerId: {}, productId: {}, quantity: {}", customerId, productId, quantity);
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
            }else if(cart.getQuantity() + quantity < 1) {
                removeFromCart(customerId, productId);
            }
            cart.setQuantity(cart.getQuantity() + quantity);
            cartMapper.updateByPrimaryKey(cart);
        }
    }

    @Override
    public void removeFromCart(Long customerId, Long productId) {
        log.info("removeFromCart start customerId: {}, productId: {}", customerId, productId);
        CartExample cartExample = new CartExample();
        cartExample.createCriteria().andCustomerIdEqualTo(customerId).andProductIdEqualTo(productId);
        cartMapper.deleteByExample(cartExample);
    }

    @Override
    public void clearCart(Long customerId) {
        log.info("clearCart start customerId: {}", customerId);
        CartExample cartExample = new CartExample();
        cartExample.createCriteria().andCustomerIdEqualTo(customerId);
        cartMapper.deleteByExample(cartExample);
    }

    @Override
    public List<ProductCartResponse> getCart(Long customerId) {
        log.info("getCart start customerId: {}", customerId);
        List<ProductCart> productCarts = cartProductMapper.getCartProduct(customerId);
        return ProductCartResponse.fromProductCarts(productCarts);
    }

    private Cart findCartByCustomerIdAndProductId(Long customerId, Long productId){
        log.info("findCartByCustomerIdAndProductId start customerId: {}, productId: {}", customerId, productId);
        CartExample cartExample = new CartExample();
        cartExample.createCriteria().andCustomerIdEqualTo(customerId).andProductIdEqualTo(productId);
        List<Cart> cartList = cartMapper.selectByExample(cartExample);
        return cartList.stream().findFirst().orElse(null);
    }


}
