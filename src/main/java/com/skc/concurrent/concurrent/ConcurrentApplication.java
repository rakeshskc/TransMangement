package com.skc.concurrent.concurrent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan("com.skc.transaction")
public class ConcurrentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcurrentApplication.class, args);
	}

}
