package com.example.ecommerce.process;

import com.example.ecommerce.db.bean.*;
import com.example.ecommerce.db.custom.bean.ProductCart;
import com.example.ecommerce.db.custom.mapper.CartProductMapper;
import com.example.ecommerce.db.custom.mapper.OrderMapper;
import com.example.ecommerce.db.mapper.OrderItemMapper;
import com.example.ecommerce.db.mapper.ProductMapper;
import com.example.ecommerce.db.mapper.TransactionOrderMapper;
import com.example.ecommerce.exception.CheckoutException;
import com.example.ecommerce.util.Constant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService implements CheckoutOrderOperations{
    private final CartProductMapper cartProductMapper;
    private final TransactionOrderMapper transactionOrderMapper;
    private final OrderItemMapper orderItemMapper;
    private final CheckoutPaymentOperations checkoutPaymentOperations;
    private final CartOperations cartOperations;

    private final ProductMapper productMapper;


    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void createOrder(Long customerId, List<Long> cartId, List<Integer> paymentId) {
        log.info("createOrder start customerId: {}, cartId: {}, paymentId: {}", customerId, cartId, paymentId);
        CartExample cartExample = new CartExample();
        cartExample.createCriteria().andCustomerIdEqualTo(customerId).andCartIdIn(cartId);
        List<ProductCart> cartList = cartProductMapper.getCartProduct(customerId);

        if(cartList.isEmpty()){
            throw new CheckoutException("Cart is empty");
        }

        TransactionOrder order = new TransactionOrder();
        order.setCustomerId(customerId);
        order.setOrderDate(new Date());
        order.setStatus(Constant.OrderStatus.PENDING);
        order.setTotalPrice(cartList.stream().map(ProductCart::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        order.setCreatedAt(new Date());
        order.setUpdatedAt(new Date());
        transactionOrderMapper.insertSelective(order);
        log.info("createOrder insert order: {}", order);

        cartList.parallelStream().forEach(productCart -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getOrderId());
            orderItem.setProductId(productCart.getProductId());
            orderItem.setQuantity(productCart.getQuantity());
            orderItem.setPrice(productCart.getPrice());
            orderItemMapper.insertSelective(orderItem);
            cartOperations.removeFromCart(customerId, productCart.getProductId());
            updateStockProduct(productCart.getProductId(), productCart.getQuantity());
        });

        checkoutPaymentOperations.createPayment(customerId, order.getOrderId(), paymentId);
    }

    private void updateStockProduct(Long productId, Integer quantity){
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andProductIdEqualTo(productId);

        Product product = new Product();
        product.setQuantity(product.getQuantity() - quantity);

        productMapper.updateByExampleSelective(product,productExample);
    }
}
