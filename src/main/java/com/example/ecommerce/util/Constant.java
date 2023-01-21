package com.example.ecommerce.util;

public class Constant {
    public static class PaymentMethod {
        public static final int GOPAY = 1;
        public static final int DEBIT_CARD = 2;
        public static final int PAYPAL = 3;
    }

    public static class PaymentStatus {
        public static final int PENDING = 101;
        public static final int SUCCESS = 102;
        public static final int FAILED = 103;
    }

    public static class OrderStatus{
        public static final int PENDING = 11;
        public static final int PAID = 12;
        public static final int SHIPPED = 13;
        public static final int DELIVERED = 14;
        public static final int COMPLETED = 15;
        public static final int CANCELLED = 16;
        public static final int REFUNDED = 17;
        public static final int DECLINED = 18;
    }
}
