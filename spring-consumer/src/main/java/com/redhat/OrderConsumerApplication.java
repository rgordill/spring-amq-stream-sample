package com.redhat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class OrderConsumerApplication {
	
	static Logger logger = LoggerFactory.getLogger(OrderConsumerApplication.class);
	
	public static void main(String[] args) {
        try {
		SpringApplication.run(OrderConsumerApplication.class, args);
        } catch (Exception e){
        	logger.error("Exception in main: ", e);
        }
	}
	
}
