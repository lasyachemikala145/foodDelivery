package com.tap.DAO;


import java.util.List;

import com.tap.model.OrderItem;

public interface OrderItemDAO {
	void addOrderItem(OrderItem oi);
	OrderItem getOrderItem(int orderItem_id);
	void updateOrderItem(OrderItem oi);
	void deleteOrderItem(int orderItem_id);
	List<OrderItem> getAllOrderItem();
	List<OrderItem> getOrderItemsByOrderId(int orderId);
	
}