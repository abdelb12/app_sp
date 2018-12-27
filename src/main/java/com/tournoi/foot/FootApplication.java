package com.tournoi.foot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class FootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootApplication.class, args);
	}

}

