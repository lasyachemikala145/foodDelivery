package com.tap.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.OrderItemDAO;
import com.tap.model.OrderItem;
import com.tap.utility.DBConnection;

public class OrderItemImpl implements OrderItemDAO {
	Connection con=DBConnection.getConnection();
	private static final String INSERT_QUERY =
			"INSERT INTO order_item(order_id, quantity, itemName, price) VALUES(?,?,?,?)";

			private static final String SELECT_QUERY =
			"SELECT orderItem_id, order_id, quantity, itemName, price FROM order_item WHERE orderItem_id=?";

			private static final String UPDATE_QUERY =
			"UPDATE order_item SET order_id=?, quantity=?, itemName=?, price=? WHERE orderItem_id=?";

			private static final String DELETE_QUERY =
			"DELETE FROM order_item WHERE orderItem_id=?";

			private static final String SELECTALL_QUERY =
			"SELECT * FROM order_item";

			private static final String SELECTR_QUERY =
					"SELECT order_id FROM `order` WHERE order_id=?";
//	1.we check whether there is keypresent or not add,update,delete
//	2.we don't need to check for get here bez if there is a value it defanatlt return 
			private static final String GET_ITEMS_BY_ORDER =
			        "SELECT * FROM order_item WHERE order_id=?";
	
	@Override
	public void addOrderItem(OrderItem oi) {
		//int order_id=0;

	    try {

	        PreparedStatement pstmt1 = con.prepareStatement(SELECTR_QUERY);
	        pstmt1.setInt(1, oi.getOrder_id());

	        ResultSet res1 = pstmt1.executeQuery();

	        if (!res1.next()) {
	            System.out.println("Invalid Order ID");
	            return;
	        }

	        PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY);

	        pstmt.setInt(1, oi.getOrder_id());
	        pstmt.setInt(2, oi.getQuantity());
	        pstmt.setString(3, oi.getItemName());
	        pstmt.setDouble(4, oi.getPrice());
	        int i = pstmt.executeUpdate();
//	        ResultSet rs=pstmt.getGeneratedKeys();
//	        if(rs.next()) {
//	        	order_id=rs.getInt(1);
//	        }

	        System.out.println(i + " row inserted");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	@Override
	public OrderItem getOrderItem(int orderItem_id) {

	    try {

	        PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY);
	        pstmt.setInt(1, orderItem_id);

	        ResultSet res = pstmt.executeQuery();

	        if (res.next()) {

	            return new OrderItem(
	                    res.getInt("orderItem_id"),
	                    res.getInt("order_id"),
	                    res.getInt("quantity"),
	                    res.getString("itemName"),
	                    res.getDouble("price"));

	        } else {

	            System.out.println("Invalid Order Item ID");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return null;
	}
	@Override
	public void updateOrderItem(OrderItem oi) {
		//before updating user we need to check whether the fk values present present in the 
		// parent table or not fk->menu id ,order-id

		    try {

		        PreparedStatement pstmt1 = con.prepareStatement(SELECTR_QUERY);
		        pstmt1.setInt(1, oi.getOrder_id());

		        ResultSet res1 = pstmt1.executeQuery();

		        if (!res1.next()) {
		            System.out.println("Invalid Order ID");
		            return;
		        }

		        PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY);

		        pstmt.setInt(1, oi.getOrder_id());
		        pstmt.setInt(2, oi.getQuantity());
		        pstmt.setString(3, oi.getItemName());
		        pstmt.setDouble(4, oi.getPrice());
		        pstmt.setInt(5, oi.getOrderItem_id());

		        int i = pstmt.executeUpdate();

		        System.out.println(i + " row updated");

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
	@Override
	public void deleteOrderItem(int orderItem_id) {
		// we just check before deleting whther there is a id or not 
		try {
			PreparedStatement pstmt1 = con.prepareStatement(SELECT_QUERY);
	        pstmt1.setInt(1, orderItem_id);

	        ResultSet res = pstmt1.executeQuery();

	        if (res.next()) {
	            

		PreparedStatement pstmt=con.prepareStatement(DELETE_QUERY);
		pstmt.setInt(1, orderItem_id);
		int i=pstmt.executeUpdate();
		System.out.println(i+"row is deleted");
		}
	        else {
	        	System.out.println("invalid oreritem id");
	        }
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<OrderItem> getAllOrderItem() {
		 List<OrderItem> orderItemList = new ArrayList<>();

		    try {
		        PreparedStatement pstmt = con.prepareStatement(SELECTALL_QUERY);

		        ResultSet res = pstmt.executeQuery();

		        while (res.next()) {

		        	int orderItem_id = res.getInt("orderItem_id");
		        	int order_id = res.getInt("order_id");
		        	//int menu_id = res.getInt("menu_id");
		        	int quantity = res.getInt("quantity");
		        	String itemName=res.getString("itemName");
		        	double price=res.getDouble("price");
		        	

		        	OrderItem orderItem = new OrderItem(orderItem_id, order_id, quantity,itemName,price);

		            orderItemList.add(orderItem);
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return orderItemList;
	}
	public List<OrderItem> getOrderItemsByOrderId(int orderId){

	    List<OrderItem> list = new ArrayList<>();

	    try{

	        PreparedStatement pstmt = con.prepareStatement(GET_ITEMS_BY_ORDER);

	        pstmt.setInt(1, orderId);

	        ResultSet res = pstmt.executeQuery();

	        while(res.next()){

	            OrderItem item = new OrderItem(

	                    res.getInt("orderItem_id"),
	                    res.getInt("order_id"),
	                    res.getInt("quantity"),
	                    res.getString("itemName"),
	                    res.getDouble("price")
	            );

	            list.add(item);
	        }

	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }

	    return list;
	}

}
