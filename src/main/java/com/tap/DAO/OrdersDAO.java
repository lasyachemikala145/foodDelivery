package com.tap.DAO;

import java.util.List;

import com.tap.model.Orders;

public interface OrdersDAO {

	    int addOrder(Orders o);

	    Orders getOrder(int order_id);

	    void updateOrder(Orders o);

	    void deleteOrder(int order_id);

	    List<Orders> getAllOrders();
	    List<Orders> getOrdersByRestaurant(int res_id);
	    void updateOrderStatus(int order_id,String status);
	    
	    //dashboard statistics
	    int getTotalOrders(int res_id);

	    int getPendingOrders(int res_id);

	    int getDeliveredOrders(int res_id);

	    float getTotalRevenue(int res_id);

	
}
