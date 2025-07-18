package com.clientdata.clientdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClientdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientdataApplication.class, args);
	}

}
