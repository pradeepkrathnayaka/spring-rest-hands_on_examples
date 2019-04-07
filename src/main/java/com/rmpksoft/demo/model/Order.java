package com.rmpksoft.demo.model;

import java.util.Date;

public class Order {

	private Long orderNumber;
	private Date date;
	private String itemName;

	public Order() {
	}

	public Order(Long orderNumber, Date date, String itemName) {
		this.orderNumber = orderNumber;
		this.date = date;
		this.itemName = itemName;
	}

	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}
