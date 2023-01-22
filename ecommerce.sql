-- ecommerce.customer definition

CREATE TABLE `customer` (
  `customer_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;


-- ecommerce.master_payment definition

CREATE TABLE `master_payment` (
  `master_payment_id` int(11) NOT NULL AUTO_INCREMENT,
  `payment_name` varchar(255) NOT NULL,
  `payment_description` varchar(255) NOT NULL,
  PRIMARY KEY (`master_payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;


-- ecommerce.master_status definition

CREATE TABLE `master_status` (
  `master_status_id` int(11) NOT NULL AUTO_INCREMENT,
  `status_id` int(11) NOT NULL,
  `status_name` varchar(255) NOT NULL,
  `status_description` varchar(255) NOT NULL,
  `status_type` varchar(255) NOT NULL,
  PRIMARY KEY (`master_status_id`),
  UNIQUE KEY `status_id` (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;


-- ecommerce.product_category definition

CREATE TABLE `product_category` (
  `product_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`product_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;


-- ecommerce.product definition

CREATE TABLE `product` (
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` decimal(20,0) NOT NULL,
  `quantity` int(11) NOT NULL,
  `image` varchar(255) NOT NULL,
  `category_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `product_product_category` (`category_id`),
  CONSTRAINT `product_product_category` FOREIGN KEY (`category_id`) REFERENCES `product_category` (`product_category_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;


-- ecommerce.transaction_order definition

CREATE TABLE `transaction_order` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_date` date DEFAULT NULL,
  `total_price` decimal(20,0) NOT NULL,
  `status` int(11) NOT NULL,
  `customer_id` bigint(20) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `order_customer` (`customer_id`),
  KEY `status` (`status`),
  CONSTRAINT `order_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `status` FOREIGN KEY (`status`) REFERENCES `master_status` (`status_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;


-- ecommerce.transaction_payment definition

CREATE TABLE `transaction_payment` (
  `payment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `payment_method` int(11) NOT NULL,
  `payment_status` int(11) NOT NULL,
  `order_id` bigint(20) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `payment_order` (`order_id`),
  KEY `payment_master_payment` (`payment_method`),
  KEY `payment_master_status` (`payment_status`),
  CONSTRAINT `payment_master_payment` FOREIGN KEY (`payment_method`) REFERENCES `master_payment` (`master_payment_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `payment_master_status` FOREIGN KEY (`payment_status`) REFERENCES `master_status` (`status_id`),
  CONSTRAINT `payment_order` FOREIGN KEY (`order_id`) REFERENCES `transaction_order` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;


-- ecommerce.cart definition

CREATE TABLE `cart` (
  `cart_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`cart_id`),
  KEY `cart_product` (`product_id`),
  KEY `cart_customer` (`customer_id`),
  CONSTRAINT `cart_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cart_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;


-- ecommerce.order_item definition

CREATE TABLE `order_item` (
  `order_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` decimal(20,0) NOT NULL,
  PRIMARY KEY (`order_item_id`),
  KEY `order_item_product` (`product_id`),
  KEY `order_item_order` (`order_id`),
  CONSTRAINT `order_item_order` FOREIGN KEY (`order_id`) REFERENCES `transaction_order` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order_item_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;


INSERT INTO ecommerce.customer
(customer_id, name, password, email, address)
VALUES(1, 'heldi', '$2a$10$WFISmXcV27UkaqL8/gLMD.LrAfHZGwmC3I.nT5u3Kv3P6Zl8YvLym', 'heldiapriadi@gmail.com', 'string');

INSERT INTO ecommerce.master_payment
(master_payment_id, payment_name, payment_description)
VALUES(1, 'Gopay', 'Pembayaran via Gopay');

INSERT INTO ecommerce.master_status
(master_status_id, status_id, status_name, status_description, status_type)
VALUES(1, 11, 'Pending', 'The order has been placed but the payment is not yet confirmed.', 'order');
INSERT INTO ecommerce.master_status
(master_status_id, status_id, status_name, status_description, status_type)
VALUES(2, 12, 'Paid', 'The payment has been confirmed and the order is being processed.', 'order');
INSERT INTO ecommerce.master_status
(master_status_id, status_id, status_name, status_description, status_type)
VALUES(3, 13, 'Shipped', 'The order has been shipped to the customer.', 'order');
INSERT INTO ecommerce.master_status
(master_status_id, status_id, status_name, status_description, status_type)
VALUES(4, 14, 'Delivered', 'The order has been shipped to the customer.', 'order');
INSERT INTO ecommerce.master_status
(master_status_id, status_id, status_name, status_description, status_type)
VALUES(5, 16, 'Canceled', 'The order has been canceled by the customer or the merchant.', 'order');
INSERT INTO ecommerce.master_status
(master_status_id, status_id, status_name, status_description, status_type)
VALUES(6, 17, 'Refunded', 'The order has been refunded to the customer.', 'order');
INSERT INTO ecommerce.master_status
(master_status_id, status_id, status_name, status_description, status_type)
VALUES(7, 15, 'Completed', 'The order has been successfully completed.', 'order');
INSERT INTO ecommerce.master_status
(master_status_id, status_id, status_name, status_description, status_type)
VALUES(8, 18, 'Declined', 'The payment for the order has been declined.', 'order');
INSERT INTO ecommerce.master_status
(master_status_id, status_id, status_name, status_description, status_type)
VALUES(9, 101, 'Pending Payment', ' ', 'payment');
INSERT INTO ecommerce.master_status
(master_status_id, status_id, status_name, status_description, status_type)
VALUES(10, 102, 'Success Payment', ' ', 'payment');
INSERT INTO ecommerce.master_status
(master_status_id, status_id, status_name, status_description, status_type)
VALUES(11, 103, 'Failed Payment', ' ', 'payment');


INSERT INTO ecommerce.product_category
(product_category_id, name, description)
VALUES(1, 'Category 1', 'Category Description 1');
INSERT INTO ecommerce.product_category
(product_category_id, name, description)
VALUES(2, 'Category 2', 'Category Description 2');

INSERT INTO ecommerce.product
(product_id, name, description, price, quantity, image, category_id)
VALUES(1, 'Product 1', 'ASASAS', 1000, 10, 'xx', 1);
INSERT INTO ecommerce.product
(product_id, name, description, price, quantity, image, category_id)
VALUES(2, 'Product 2', 'XXX', 2000, 15, 'SS', 1);
INSERT INTO ecommerce.product
(product_id, name, description, price, quantity, image, category_id)
VALUES(3, 'Product 3', 'SSS', 5000, 5, 'ff', 2);
INSERT INTO ecommerce.product
(product_id, name, description, price, quantity, image, category_id)
VALUES(4, 'Product 4', 'EEE', 7500, 16, 'ff', 2);
