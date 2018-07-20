package com.redhat;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface OrderInterface {
	  String OUTPUT = "orderRequest";

	  @Output(OrderInterface.OUTPUT)
	  MessageChannel output();
}
