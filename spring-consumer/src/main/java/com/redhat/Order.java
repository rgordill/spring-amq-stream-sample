package com.redhat;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Order implements Serializable {

	private String id;

	private String productName;

    private String amount;
    
    private String status;
	

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}