package com.tap.model;

import java.sql.Timestamp;
import java.time.LocalTime;

public class Restaurent {



	    private int res_id;
	    private String name;
	    private String address;
	    private String cuisineType;
	    private int deliveryTime;      // in minutes
	    private float rating;          // 4.5
	    private float discount;        // 20 means 20% off
	    

	    private LocalTime openTime; 
	    private LocalTime closeTime;
	    
	    private String imageUrl;
	    private String description;
		public Restaurent(int res_id,String name, String address, String cuisineType, int deliveryTime, float rating,
				float discount, LocalTime openTime, LocalTime closeTime, String imageUrl, String description) {
			super();
			this.res_id = res_id;
			this.name = name;
			this.address = address;
			this.cuisineType = cuisineType;
			this.deliveryTime = deliveryTime;
			this.rating = rating;
			this.discount = discount;
			this.openTime=openTime;
			this.closeTime=closeTime;
			this.imageUrl = imageUrl;
			this.description = description;
		}
		public Restaurent(String name, String address, String cuisineType, int deliveryTime, float rating,
				float discount, LocalTime openTime, LocalTime closeTime, String imageUrl, String description) {
			super();
			this.name = name;
			this.address = address;
			this.cuisineType = cuisineType;
			this.deliveryTime = deliveryTime;
			this.rating = rating;
			this.discount = discount;
			this.openTime = openTime;
			this.closeTime = closeTime;
			this.imageUrl = imageUrl;
			this.description = description;
		}
		public Restaurent() {
			super();
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
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCuisineType() {
			return cuisineType;
		}
		public void setCuisineType(String cuisineType) {
			this.cuisineType = cuisineType;
		}
		public int getDeliveryTime() {
			return deliveryTime;
		}
		public void setDeliveryTime(int deliveryTime) {
			this.deliveryTime = deliveryTime;
		}
		public float getRating() {
			return rating;
		}
		public void setRating(float rating) {
			this.rating = rating;
		}
		public float getDiscount() {
			return discount;
		}
		public void setDiscount(float discount) {
			this.discount = discount;
		}
		
		public LocalTime getOpenTime() {
			return openTime;
		}
		public void setOpenTime(LocalTime openTime) {
			this.openTime = openTime;
		}
		public LocalTime getCloseTime() {
			return closeTime;
		}
		public void setCloseTime(LocalTime closeTime) {
			this.closeTime = closeTime;
		}
		public String getImageUrl() {
			return imageUrl;
		}
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	    
	}
	
