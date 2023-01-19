package com.example.ecommerce;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScans(value = {
		@MapperScan("com.example.ecommerce.db.mapper"),
		@MapperScan("com.example.ecommerce.db.custom.mapper")
})
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

}
