package com.tap.model;

public class CartItem {
	private int menu_id;
	private int res_id;
	private String name;
	private float price;
	private int quantity;
	public CartItem() {
		super();
	}
	public CartItem(int menu_id, int res_id, String name, float price, int quantity) {
		super();
		this.menu_id = menu_id;
		this.res_id = res_id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public int getRes_id() {
		return res_id;
	}
	public void setRes_id(int res_id) {
		this.res_id = res_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalPrice() {
		return quantity*(int)price;
	}
	
	
}
