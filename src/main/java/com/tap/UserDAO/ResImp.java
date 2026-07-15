package com.tap.UserDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;

import com.food.servlet.RestaurantServlet;
//import com.res.model.Restaurent;
import com.tap.DAO.ResInterface;
import com.tap.model.Restaurent;
import com.tap.utility.DBConnection;
public class ResImp implements ResInterface{

	private static final String INSERT_QUERY =
			"INSERT INTO restaurant(name,address,cuisineType, deliveryTime, description, discount, rating, imageUrl,openTime,closeTime) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_QUERY="Select * from restaurant where res_id=?";
	private static final String SELECT_QUERY1="Select description,delivarytiming,rating,image_path from restaurant where name=?";
	private static final String UPDATE_QUERY="UPDATE restaurant SET name=?, address=?,cuisineType=?,deliveryTime=?,description=?,"
			+"discount=?, rating=?,imageUrl=?,opentime=?,closetime=? where res_id=?";
	private static final String DELETE_QUERY="DELETE FROM restaurant WHERE  res_id=?";
	private static final String SELECT_ALL_QUERY="SELECT * FROM restaurant";
	private static final String SEARCH_QUERYLike=
		    "SELECT * FROM restaurant WHERE name LIKE ? OR cuisineType LIKE ?";
	private static final String SEARCH_QUERYLike1 =
			//private static final String SEARCH_QUERYLike1 =
		    "SELECT * FROM restaurant " +
		    "WHERE name LIKE ? " +
		    "OR cuisineType LIKE ?";

	Connection con=DBConnection.getConnection();

	public void addRes(Restaurent res) {
		//Connection con=DBConnection.getConnection();	
		try {

			PreparedStatement stmt = con.prepareStatement(INSERT_QUERY);

			stmt.setString(1, res.getName());
			stmt.setString(2, res.getAddress());
			stmt.setString(3, res.getCuisineType());
			stmt.setInt(4, res.getDeliveryTime());
			stmt.setString(5, res.getDescription());
			stmt.setFloat(6, res.getDiscount());
			stmt.setFloat(7, res.getRating());
			stmt.setString(8,res.getImageUrl());
			stmt.setObject(9, res.getCloseTime());
			stmt.setObject(10, res.getOpenTime());



			int i = stmt.executeUpdate();

			System.out.println(i + " row inserted");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Restaurent getRes(int res_id) {
		try {
			PreparedStatement stmt = con.prepareStatement(SELECT_QUERY);
			stmt.setInt(1, res_id);
			ResultSet res=stmt.executeQuery();
			Restaurent res1=null;
			while(res.next()) {
				int resid=res.getInt("res_id");
				String name=res.getString("name");
				String des=res.getString("description");
				int date=res.getInt("deliveryTime");
				float rating=res.getFloat("rating");
				String img=res.getString("imageUrl");
				float discount=res.getFloat("discount");
				String address=res.getString("address");
				String cusine=res.getString("cuisineType");
				LocalTime opentime = res.getObject("openTime", LocalTime.class);
				LocalTime closetime = res.getObject("closeTime", LocalTime.class);



				res1=new Restaurent(resid,name,address,cusine,date,rating,discount,opentime,closetime,img,des);
			}
			return res1;

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	public void updateRes(Restaurent res) {
		try {
			PreparedStatement pstmt=con.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, res.getName());
			pstmt.setString(2, res.getAddress());
			pstmt.setString(3, res.getCuisineType());
			pstmt.setInt(4, res.getDeliveryTime());
			pstmt.setString(5, res.getDescription());
			pstmt.setFloat(6, res.getDiscount());
			pstmt.setFloat(7, res.getRating());
			pstmt.setString(8, res.getImageUrl());

			// LocalTime values
			pstmt.setObject(9, res.getOpenTime());
			pstmt.setObject(10, res.getCloseTime());

			// WHERE res_id = ?
			pstmt.setInt(11, res.getRes_id());

			int rows = pstmt.executeUpdate();

			System.out.println(rows + " row updated");

		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}
	public void deleteRes(int res_id) {
		try {

			PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY);

			// Set the res_id value
			pstmt.setInt(1, res_id);

			// Execute the delete query
			int rows = pstmt.executeUpdate();

			System.out.println(rows + " row deleted");

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Restaurent> getAllRestaurent() {

	    List<Restaurent> list = new ArrayList<>();

	   // con = DBConnection.getConnection();
	    con = DBConnection.getConnection();

	    System.out.println(con);

	    if (con == null) {
	        System.out.println("Connection is NULL");
	        return list;
	    }
	    

	    try {

	        Statement pstmt = con.createStatement();

	        ResultSet res = pstmt.executeQuery(SELECT_ALL_QUERY);

	        while (res.next()) {

	            int resi = res.getInt("res_id");
	            String name = res.getString("name");
	            String add = res.getString("address");
	            String cusine = res.getString("cuisineType");
	            int dtime = res.getInt("deliveryTime");
	            String des = res.getString("description");
	            float discount = res.getFloat("discount");
	            float rate = res.getFloat("rating");
	            String imageUrl = res.getString("imageUrl");
	            LocalTime opentime = res.getObject("openTime", LocalTime.class);
	            LocalTime closeTime = res.getObject("closeTime", LocalTime.class);
  
	            Restaurent res1 = new Restaurent(
	                    resi, name, add, cusine, dtime,
	                    rate,discount, opentime, closeTime,
	                    imageUrl,des);

	            list.add(res1);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	public List<Restaurent> getbyRestaurent(int res_id) {

	    List<Restaurent> list = new ArrayList<>();

	    try {

	        PreparedStatement pstmt = con.prepareStatement(
	                "SELECT * FROM restaurant WHERE res_id = ?");

	        pstmt.setInt(1, res_id);

	        ResultSet res = pstmt.executeQuery();

	        while (res.next()) {

	            int resi = res.getInt("res_id");
	            String name = res.getString("name");
	            String add = res.getString("address");
	            String cuisine = res.getString("cuisineType");
	            int dtime = res.getInt("deliveryTime");
	            String des = res.getString("description");
	            float discount = res.getFloat("discount");
	            float rate = res.getFloat("rating");
	            String imageUrl = res.getString("imageUrl");
	            LocalTime openTime = res.getObject("openTime", LocalTime.class);
	            LocalTime closeTime = res.getObject("closeTime", LocalTime.class);

	            Restaurent restaurant = new Restaurent(
	                    resi,
	                    name,
	                    add,
	                    cuisine,
	                    dtime,
	                    rate,
	                    discount,
	                    openTime,
	                    closeTime,
	                    imageUrl,
	                    des
	            );

	            list.add(restaurant);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	public List<Restaurent> searchRestaurant(String keyword) {
		List<Restaurent> restaurentlist=new ArrayList<>();
		
		try {
		PreparedStatement pstmt = con.prepareStatement(SEARCH_QUERYLike1);
		String search = "%" + keyword + "%";

		pstmt.setString(1, search);
		pstmt.setString(2, search);
		//pstmt.setString(3, search);
		ResultSet res=pstmt.executeQuery();
		while(res.next()) {
			//actually we are geeting and store but can also do like this 
			Restaurent r = new Restaurent();

			r.setRes_id(res.getInt("res_id"));
		    r.setName(res.getString("name"));
            r.setCuisineType(res.getString("cuisineType"));
            r.setRating(res.getFloat("rating"));
            r.setDeliveryTime(res.getInt("deliveryTime"));
            r.setImageUrl(res.getString("imageUrl"));
            r.setAddress(res.getString("address"));
            r.setDiscount(res.getFloat("discount"));
            restaurentlist.add(r);
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return restaurentlist;

	}
	public List<Restaurent> filterRestaurants(String category,
			String cuisine,
			String rating,
			String price,
			String sort) {

		List<Restaurent> list = new ArrayList<>();

		StringBuilder sql = new StringBuilder(
				"SELECT DISTINCT r.* FROM restaurant r " +
						"JOIN menu m ON r.res_id = m.res_id WHERE 1=1 "
				);

		List<Object> params = new ArrayList<>();

		// Veg / Non Veg
		if(category != null && !category.isEmpty()) {
			sql.append(" AND m.category = ? ");
			params.add(category);
		}

		// Cuisine
		if(cuisine != null && !cuisine.isEmpty()) {
			sql.append(" AND r.cuisineType = ? ");
			params.add(cuisine);
		}

		// Rating
		if(rating != null && !rating.isEmpty()) {
			sql.append(" AND r.rating >= ? ");
			params.add(Float.parseFloat(rating));
		}

		// Price
		if(price != null && !price.isEmpty()) {

			int p = Integer.parseInt(price);

			if(p == 200) {
				sql.append(" AND m.price <= 200 ");
			}
			else if(p == 400) {
				sql.append(" AND m.price BETWEEN 200 AND 400 ");
			}
			else {
				sql.append(" AND m.price > 400 ");
			}
		}

		// Sort
		if(sort != null && !sort.isEmpty()) {

			switch(sort) {

			case "rating":
				sql.append(" ORDER BY r.rating DESC ");
				break;

			case "delivery":
				sql.append(" ORDER BY r.deliveryTime ASC ");
				break;

			case "az":
				sql.append(" ORDER BY r.name ASC ");
				break;
			}
		}

		try {

			PreparedStatement pstmt =
					con.prepareStatement(sql.toString());

			for(int i=0;i<params.size();i++) {
				pstmt.setObject(i+1, params.get(i));
			}

			ResultSet res = pstmt.executeQuery();

			while(res.next()) {

				Restaurent r = new Restaurent();

				r.setRes_id(res.getInt("res_id"));
				r.setName(res.getString("name"));
				r.setAddress(res.getString("address"));
				r.setCuisineType(res.getString("cuisineType"));
				r.setDeliveryTime(res.getInt("deliveryTime"));
				r.setDescription(res.getString("description"));
				r.setDiscount(res.getFloat("discount"));
				r.setRating(res.getFloat("rating"));
				r.setImageUrl(res.getString("imageUrl"));
				r.setOpenTime(res.getObject("openTime", LocalTime.class));
				r.setCloseTime(res.getObject("closeTime", LocalTime.class));

				list.add(r);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return list;
	}


}

