package com.example.ecommerce.process;

import com.example.ecommerce.db.bean.TransactionPayment;
import com.example.ecommerce.db.mapper.TransactionPaymentMapper;
import com.example.ecommerce.util.Constant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService implements CheckoutPaymentOperations {

    private final TransactionPaymentMapper paymentMapper;

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void createPayment(Long customerId, Long orderId, List<Integer> paymentId) {
        log.info("createPayment start customerId: {}, orderId: {}, paymentId: {}", customerId, orderId, paymentId);
        paymentId.parallelStream().forEach(payment -> {
            TransactionPayment newPayment = new TransactionPayment();
            newPayment.setOrderId(customerId);
            newPayment.setPaymentMethod(payment);
            newPayment.setCreatedAt(new Date());
            newPayment.setUpdatedAt(new Date());
            newPayment.setOrderId(orderId);
            newPayment.setPaymentStatus(Constant.PaymentStatus.PENDING);
            paymentMapper.insert(newPayment);
        });
    }
}
