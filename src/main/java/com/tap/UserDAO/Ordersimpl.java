package com.tap.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.OrdersDAO;
import com.tap.model.Orders;
import com.tap.utility.DBConnection;

public class Ordersimpl implements OrdersDAO{
	private static final String INSERT_QUERY ="INSERT INTO `order`(user_id,res_id,finalprice,"
			+"orderdate,status,delivery_address,payment) VALUES(?,?,?,?,?,?,?)";

	private static final String SELECT_QUERY ="SELECT * FROM `order` WHERE order_id=?";

	private static final String UPDATE_QUERY ="UPDATE `order` SET user_id=?,res_id=?,"
			+"finalprice=?,orderdate=?,status=? WHERE order_id=?";

	private static final String DELETE_QUERY ="DELETE FROM `order` WHERE order_id=?";

	private static final String GET_ALL_QUERY ="SELECT * FROM `order`";
	private static final String SELECTR_QUERY="SELECT * from restaurant where res_id=?";
	private static final String SELECTU_QUERY="SELECT * from user_table where user_id=?";
	private static final String GET_USER_ORDERS =
	        "SELECT * FROM `order` WHERE user_id=? ORDER BY orderdate DESC";
	Connection con=DBConnection.getConnection();
	private static final String GET_RESTAURANT_ORDERS =
	        "SELECT * FROM `order` WHERE res_id=? ORDER BY orderdate DESC";
	private static final String UPDATE_ORDER_STATUS =
			"UPDATE `order` SET status=? WHERE order_id=?";

	@Override
	public int addOrder(Orders o) {
		int order_id=0;
		try{
			PreparedStatement pstmt2=con.prepareStatement(SELECTR_QUERY);
			pstmt2.setInt(1,o.getRes_id());
			ResultSet res=pstmt2.executeQuery();
			if(res.next()) {
			
				System.out.println("valid");
				
			}
			else{
				System.out.println("invalid restaurent id please check in restaurent table "
						+ "");
				return -1;
			}
		
			PreparedStatement pstmt1=con.prepareStatement(SELECTU_QUERY);
			pstmt1.setInt(1,o.getUser_id());
			ResultSet res1=pstmt1.executeQuery();
			if(res1.next()) {
			
				System.out.println("valid");
				
			}
			else{
				System.out.println("invalid USER ID please check in user table");
				return -1;
			}
		 
			PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY,Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, o.getUser_id());
			pstmt.setInt(2, o.getRes_id());
			pstmt.setFloat(3, o.getFinalprice());
			pstmt.setObject(4, o.getOrderdate());   // LocalDateTime
			pstmt.setString(5, o.getStatus());
			pstmt.setString(6, o.getDelivery_address());
			pstmt.setString(7,o.getPayment());

			pstmt.executeUpdate();
			System.out.println("Order Added Successfully");
			ResultSet rs=pstmt.getGeneratedKeys();
			if(rs.next()) {
				order_id=rs.getInt(1);
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
return order_id;
	}
	Orders or;
	@Override
	public Orders getOrder(int order_id) {
		//Orders or;
		try {
			PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY);

			pstmt.setInt(1, order_id);

			ResultSet res = pstmt.executeQuery();

			if(res.next()) {

				int id = res.getInt("order_id");
				int userId = res.getInt("user_id");
				int resId = res.getInt("res_id");
				float finalPrice = res.getFloat("finalprice");
				LocalDateTime orderDate = (LocalDateTime) res.getObject("orderdate");
				String paymentStatus = res.getString("status");
				String payment=res.getString("payment");
				String delivery_address=res.getString("delivery_address");
				

				return new Orders(
					    id,
					    userId,
					    resId,
					    finalPrice,
					    orderDate,
					    paymentStatus,
					    delivery_address,
					    payment
					);
			}
			else {
				System.out.println("invalid order id ");
				return null;
				
			}
			 
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
//		if an exception occurs inside the try block, execution jumps to the catch block.
//		After the catch block finishes, the method still needs to return an Orders objec
	}

	@Override
	public void updateOrder(Orders o) {
		//check fk keys exist or not 
		try {
			PreparedStatement pstmt2=con.prepareStatement(SELECTR_QUERY);
			pstmt2.setInt(1,o.getRes_id());
			ResultSet res=pstmt2.executeQuery();
			if(res.next()) {
			
				System.out.println("valid");
				
			}
			else{
				System.out.println("invalid restaurent id please check in restaurent table "
						+ "");
				return;
			}
		
			PreparedStatement pstmt1=con.prepareStatement(SELECTU_QUERY);
			pstmt1.setInt(1,o.getUser_id());
			ResultSet res1=pstmt1.executeQuery();
			if(res1.next()) {
			
				System.out.println("valid");
				
			}
			else{
				System.out.println("invalid USER ID please check in user table");
				return;
			}
			//update logic
			PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY);

			pstmt.setInt(1, o.getUser_id());
			pstmt.setInt(2, o.getRes_id());
			pstmt.setFloat(3, o.getFinalprice());
			pstmt.setObject(4, LocalDateTime.now());   // LocalDateTime
			pstmt.setString(5, o.getStatus());
			pstmt.setInt(6, o.getOrder_id());

			int i = pstmt.executeUpdate();
			System.out.println(i+"Rows updated");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteOrder(int order_id) {
		try {
			// Check whether order_id exists
			PreparedStatement pstmt1 = con.prepareStatement(SELECT_QUERY);
			pstmt1.setInt(1, order_id);

			ResultSet res = pstmt1.executeQuery();

			if (res.next()) {
				PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY);

				pstmt.setInt(1, order_id);

				int i = pstmt.executeUpdate();
				System.out.println(i+"row effected");

			}
			  else {
				System.out.println("invalid order_id");
			}
		}
		catch(SQLException e) {

		}
	}
	
	@Override
	public List<Orders> getAllOrders() {
		List<Orders> li=new ArrayList();
		try {
			PreparedStatement pstmt = con.prepareStatement(GET_ALL_QUERY);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {

				int orderId = res.getInt("order_id");
				int userId = res.getInt("user_id");
				int resId = res.getInt("res_id");
				float finalPrice = res.getFloat("finalprice");
				LocalDateTime orderDate = (LocalDateTime) res.getObject("orderdate");
				String paymentStatus = res.getString("statuspayment");

				Orders order = new Orders(orderId,userId,resId,finalPrice,orderDate,paymentStatus);

				li.add(order);
			}

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return li;
	}
	public List<Orders> getOrdersByUser(int userId){

	    List<Orders> list = new ArrayList<>();

	    try{

	        PreparedStatement pstmt = con.prepareStatement(GET_USER_ORDERS);

	        pstmt.setInt(1, userId);

	        ResultSet res = pstmt.executeQuery();

	        while(res.next()){

	            Orders order = new Orders(
	                    res.getInt("order_id"),
	                    res.getInt("user_id"),
	                    res.getInt("res_id"),
	                    res.getFloat("finalprice"),
	                    (LocalDateTime)res.getObject("orderdate"),
	                    res.getString("status"),
	                    
	                    res.getString("delivery_address"),
	                    res.getString("payment")
	            );

	            list.add(order);
	        }

	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }

	    return list;
	}
	@Override
	public List<Orders> getOrdersByRestaurant(int res_id) {

	    List<Orders> orderList = new ArrayList<>();

	    try {

	        PreparedStatement pstmt = con.prepareStatement(GET_RESTAURANT_ORDERS);

	        pstmt.setInt(1, res_id);

	        ResultSet res = pstmt.executeQuery();

	        while (res.next()) {

	            Orders order = new Orders(
	                    res.getInt("order_id"),
	                    res.getInt("user_id"),
	                    res.getInt("res_id"),
	                    res.getFloat("finalprice"),
	                    (LocalDateTime) res.getObject("orderdate"),
	                    res.getString("status"),
	                    res.getString("delivery_address"),
	                    res.getString("payment")
	            );

	            orderList.add(order);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return orderList;
	}
	@Override
	public void updateOrderStatus(int order_id, String status) {

	    try {

	        PreparedStatement pstmt =
	                con.prepareStatement(UPDATE_ORDER_STATUS);

	        pstmt.setString(1, status);
	        pstmt.setInt(2, order_id);

	        int i = pstmt.executeUpdate();

	        System.out.println(i + " Order Status Updated");

	    }
	    catch(Exception e) {

	        e.printStackTrace();

	    }

	}
	//total orders
	@Override
	public int getTotalOrders(int res_id) {

	    int count = 0;

	    try {

	        PreparedStatement pstmt =
	                con.prepareStatement("SELECT COUNT(*) FROM `order` WHERE res_id=?");

	        pstmt.setInt(1, res_id);

	        ResultSet rs = pstmt.executeQuery();

	        if(rs.next()) {
	            count = rs.getInt(1);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return count;
	}
	//pending orders
	@Override
	public int getPendingOrders(int res_id) {

	    int count = 0;

	    try {

	        PreparedStatement pstmt =
	                con.prepareStatement("SELECT COUNT(*) FROM `order` WHERE res_id=? AND status='Pending'");

	        pstmt.setInt(1, res_id);

	        ResultSet rs = pstmt.executeQuery();

	        if(rs.next()) {
	            count = rs.getInt(1);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return count;
	}
	//delivered orders
	@Override
	public int getDeliveredOrders(int res_id) {

	    int count = 0;

	    try {

	        PreparedStatement pstmt =
	                con.prepareStatement("SELECT COUNT(*) FROM `order` WHERE res_id=? AND status='Delivered'");

	        pstmt.setInt(1, res_id);

	        ResultSet rs = pstmt.executeQuery();

	        if(rs.next()) {
	            count = rs.getInt(1);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return count;
	}
	//total revenue
	@Override
	public float getTotalRevenue(int res_id) {

	    float revenue = 0;

	    try {

	        PreparedStatement pstmt =
	                con.prepareStatement("SELECT SUM(finalprice) FROM `order` WHERE res_id=? AND status='Delivered'");

	        pstmt.setInt(1, res_id);

	        ResultSet rs = pstmt.executeQuery();

	        if(rs.next()) {
	            revenue = rs.getFloat(1);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return revenue;
	}
}
