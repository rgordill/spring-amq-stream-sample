package com.redhat;

import java.io.Serializable;

//import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@ApiModel(value = "Order")
@JsonPropertyOrder({"id","product","amount"})
//@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class Order implements Serializable {

	@ApiModelProperty(value="Id", readOnly=true, position=1)
	@JsonProperty("id")
	private String id;
	
	@ApiModelProperty(value="Product", position=2)
	@JsonProperty("product")
	private String productName;
	
	@ApiModelProperty(value="Amount", position=3)
	@JsonProperty("amount")
    private String amount;
	

	public Order(){
	}
    
	public String getId() {
        return id;
    }

	public void setId(String id) {
        this.id = id;
    }
	
    public String getProductName() {
        return productName;
    }

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
    	
}