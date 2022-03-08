package com.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class TransactionPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionPocApplication.class, args);
	}

}
