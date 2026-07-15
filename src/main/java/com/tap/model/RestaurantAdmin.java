package com.tap.model;

public class RestaurantAdmin {

	    private int admin_id;
	    private int restaurant_id;
	    private String name;
	    private String email;
	    private String password;

	    public RestaurantAdmin() {
	    }

	    public RestaurantAdmin(int admin_id, int restaurant_id, String name, String email, String password) {
	        this.admin_id = admin_id;
	        this.restaurant_id = restaurant_id;
	        this.name = name;
	        this.email = email;
	        this.password = password;
	    }

	    public int getAdmin_id() {
	        return admin_id;
	    }

	    public void setAdmin_id(int admin_id) {
	        this.admin_id = admin_id;
	    }

	    public int getRestaurant_id() {
	        return restaurant_id;
	    }

	    public void setRestaurant_id(int restaurant_id) {
	        this.restaurant_id = restaurant_id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }
	}
