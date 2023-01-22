package com.example.ecommerce;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@MapperScans(value = {
		@MapperScan("com.example.ecommerce.db.mapper"),
		@MapperScan("com.example.ecommerce.db.custom.mapper")
})
@SecurityScheme(name = "Bearer Authentication", scheme = "bearer", bearerFormat = "JWT" ,type = SecuritySchemeType.HTTP)
@EnableMongoRepositories
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

}
