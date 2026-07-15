package com.tap.model;

public class OrderItem {
	private int orderItem_id;
	private int order_id;
	private String itemName;
	private int quantity;
	private double price;
	
	
	public OrderItem() {
		super();
	}
	
	public int getOrderItem_id() {
		return orderItem_id;
	}

	public void setOrderItem_id(int orderItem_id) {
		this.orderItem_id = orderItem_id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public OrderItem(int order_id,int quantity,String itemName, double price) {
		
		this.order_id = order_id;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}

	public OrderItem(int orderItem_id, int order_id, int quantity, String itemName,double price) {
		
		this.orderItem_id = orderItem_id;
		this.order_id = order_id;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}

	public int getOrderitem_id() {
		return orderItem_id;
	}
	public void setOrderitem_id(int orderItem_id) {
		this.orderItem_id = orderItem_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}



