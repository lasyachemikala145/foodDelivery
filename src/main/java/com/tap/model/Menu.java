package com.tap.model;

public class Menu {
	
	
	private int menu_id;
	private String nameofitem;
	private float price;
	private float rating;
	private String category;
	private int res_id;
	private String imgurl;
	private int quantity;
	private String restaurantName;

	public String getRestaurantName() {
	    return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
	    this.restaurantName = restaurantName;
	}

	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getImgurl() {
		return imgurl;
	}


	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}


	public int getMenu_id() {
		return menu_id;
	}


	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}


	public String getNameofitem() {
		return nameofitem;
	}


	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", nameofitem=" + nameofitem + ", price=" + price + ", rating=" + rating
				+ ", category=" + category + ", res_id=" + res_id + "]";
	}


	public void setNameofitem(String nameofitem) {
		this.nameofitem = nameofitem;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getRes_id() {
		return res_id;
	}


	public void setRes_id(int res_id) {
		this.res_id = res_id;
	}


	public Menu(String nameofitem, float price, float rating, String category, int res_id) {
		super();
		this.nameofitem = nameofitem;
		this.price = price;
		this.rating = rating;
		this.category = category;
		this.res_id = res_id;
	}


	public Menu() {
		super();
	}


	public Menu(int menu_id, String nameofitem, float price, float rating, String category, int res_id,String imgurl) {
		super();
		this.menu_id = menu_id;
		this.nameofitem = nameofitem;
		this.price = price;
		this.rating = rating;
		this.category = category;
		this.res_id = res_id;
		this.imgurl=imgurl;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
