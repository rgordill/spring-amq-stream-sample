package com.redhat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;


@EnableBinding(OrderInterface.class)
public class OrderController {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @StreamListener(OrderInterface.INPUT)
    @SendTo(OrderInterface.OUTPUT)
    public Order handle(Order order) {
		log.info("Got order " + order.getId());

		order.setStatus("completed");
		
		return order;
	}
}