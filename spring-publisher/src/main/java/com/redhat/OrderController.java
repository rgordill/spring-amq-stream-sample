package com.redhat;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@EnableBinding(OrderInterface.class)
public class OrderController {
    Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private OrderInterface orderInterface;
	
    @RequestMapping(method=RequestMethod.GET,value="/order/{id}")
    @ApiOperation(
            value = "Get Order",
            notes = "Get a Order by id")
    public Order getOrder(
    		@PathVariable(value="id") String id
    		) {
    	return null;
    }

//    @SendTo(OrderInterface.OUTPUT)
    @RequestMapping(method=RequestMethod.PUT,value="/order")
    @ApiOperation(
            value = "Create a Order",
            notes = "Create a Order serialized in JSON")
    public Order putOrder(
    		@ApiParam(value = "Order object", required = true, name = "Order") @RequestBody Order c
    		) {
    	
    	c.setId(UUID.randomUUID().toString());
    	
    	Message m = MessageBuilder.withPayload(c).build();
    	log.info("Sending " + m);
    	orderInterface.output().send(m);
    	
        return c;
    }

       
    @ResponseStatus(value=HttpStatus.NOT_FOUND,reason="This order is not found in the system")
    public class OrderNotFoundException extends RuntimeException 
    {
    	private static final long serialVersionUID = 100L;
    }
    
}