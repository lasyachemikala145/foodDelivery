package com.tap.model;
import java.sql.Date;
import java.time.LocalDateTime;
public class Orders {
	


	    private int order_id;
	    private int user_id;
	    private int res_id;
	    private float finalprice;
	    private LocalDateTime orderdate;
	    private String status;
	    private String delivery_address;
	    private String payment;

	    
		public String getDelivery_address() {
			return delivery_address;
		}

		public void setDelivery_address(String delivery_address) {
			this.delivery_address = delivery_address;
		}

		public Orders(int order_id, int user_id, int res_id, float finalprice, LocalDateTime orderdate,
				String status, String delivery_address,String payment) {
			super();
			this.order_id = order_id;
			this.user_id = user_id;
			this.res_id = res_id;
			this.finalprice = finalprice;
			this.orderdate = orderdate;
			this.status = status;
			this.payment = payment;
			this.delivery_address = delivery_address;
		}

		public String getPayment() {
			return payment;
		}

		public void setPayment(String payment) {
			this.payment = payment;
		}

		public Orders() {

	    }

	    // Constructor for Insert
	    public Orders(int user_id, int res_id, float finalprice,
	            LocalDateTime orderdate, String status) {

	        this.user_id = user_id;
	        this.res_id = res_id;
	        this.finalprice = finalprice;
	        this.orderdate = orderdate;
	        this.status = status;
	    }

	    // Constructor for Update/Get
	    public Orders(int order_id, int user_id, int res_id,
	            float finalprice, LocalDateTime orderdate, String status) {

	        this.order_id = order_id;
	        this.user_id = user_id;
	        this.res_id = res_id;
	        this.finalprice = finalprice;
	        this.orderdate = orderdate;
	        this.status = status;
	    }

	    public int getOrder_id() {
	        return order_id;
	    }

	    public void setOrder_id(int order_id) {
	        this.order_id = order_id;
	    }

	    public int getUser_id() {
	        return user_id;
	    }

	    public void setUser_id(int user_id) {
	        this.user_id = user_id;
	    }

	    public int getRes_id() {
	        return res_id;
	    }

	    public void setRes_id(int res_id) {
	        this.res_id = res_id;
	    }

	    public float getFinalprice() {
	        return finalprice;
	    }

	    public void setFinalprice(float finalprice) {
	        this.finalprice = finalprice;
	    }

	    public LocalDateTime getOrderdate() {
	        return orderdate;
	    }

	    public void setOrderdate(LocalDateTime orderdate) {
	        this.orderdate = orderdate;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    @Override
	    public String toString() {
	        return "Orders [order_id=" + order_id +
	                ", user_id=" + user_id +
	                ", res_id=" + res_id +
	                ", finalprice=" + finalprice +
	                ", orderdate=" + orderdate +
	                ", statuspayment=" + status + "]";
	    }

		
	}

