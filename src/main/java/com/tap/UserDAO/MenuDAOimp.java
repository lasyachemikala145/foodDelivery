package com.tap.UserDAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.Menudao;
import com.tap.model.Menu;
import com.tap.model.Restaurent;
import com.tap.utility.DBConnection;

public class MenuDAOimp implements Menudao{
	// TODO Auto-generated method stub
	private static final String INSERT_QUERY ="INSERT INTO menu(nameofitem, price, rating, category, res_id) "
			+ "VALUES(?,?,?,?,?)";
	private static final String INSERT_QUERY2 =
			"INSERT INTO menu(nameofitem, price, rating, category, res_id, imgurl) VALUES(?,?,?,?,?,?)";
	private static final String SELECT_QUERY =
			"Select menu_id, nameofitem, price, rating, category, res_id, imgurl from menu where menu_id=?";
	private static final String UPDATE_QUERY =
			"UPDATE menu SET nameofitem=?, price=?, rating=?, category=?, res_id=?, imgurl=? WHERE menu_id=?";
	private static final String DELETE_QUERY ="DELETE FROM menu WHERE menu_id=?";
	private static final String GETALL_QUERY ="SELECT * FROM menu";
	private static final String SELECT_UQUERY="SELECT * from restaurant where res_id=?";
	private static final String GET_MENU_BY_RESTAURANT="SELECT * from menu where res_id=?";
	private static final String SEARCH_MENU =
			"SELECT m.*, r.name AS restaurantName " +
			"FROM menu m " +
			"JOIN restaurant r ON m.res_id = r.res_id " +
			"WHERE m.nameofitem LIKE ? OR m.category LIKE ?";
	Connection con=DBConnection.getConnection();
	@Override
	public void addMenu(Menu m) {
		try{
			PreparedStatement pstmt1=con.prepareStatement(SELECT_UQUERY);
			pstmt1.setInt(1,m.getRes_id());
			ResultSet res=pstmt1.executeQuery();
			if(res.next()) {
				//int resid=res.getInt("res_id");
			
				System.out.println("valid");
			PreparedStatement pstmt=con.prepareStatement(INSERT_QUERY);
			pstmt.setString(1,m.getNameofitem());
			pstmt.setFloat(2,m.getPrice());
			pstmt.setFloat(3, m.getRating());
			pstmt.setString(4,m.getCategory());
			pstmt.setInt(5,m.getRes_id());
			int i=pstmt.executeUpdate();
			System.out.println(i+"row is effected");
		}
			else{
				System.out.println("invalid");
				return;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		
		}
	}
	@Override
	public Menu getMenu(int menu_id) {
		try {
			PreparedStatement pstmt=con.prepareStatement(SELECT_QUERY);
			pstmt.setInt(1, menu_id);
			ResultSet res=pstmt.executeQuery();
			if(res.next()) {//what ever column names we mentioned in thw query those only we get
				int id=res.getInt("menu_id");
				String name=res.getString("nameofitem");
				float price = res.getFloat("price");
				float rating = res.getFloat("rating");
				String category = res.getString("category");
				int resId = res.getInt("res_id");
				 String imgurl = res.getString("imgurl");

				Menu menu = new Menu(id, name, price, rating, category, resId,imgurl);

				return menu;
			}
			else {
				System.out.println("enter valid menu_id");
			}

		} catch (SQLException e) {
			 System.out.println("GET MENU ERROR");
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void updateMenu(Menu m) {
		try {
			PreparedStatement pstmt1=con.prepareStatement(SELECT_UQUERY);
			pstmt1.setInt(1,m.getRes_id());
			ResultSet res=pstmt1.executeQuery();
			if (!res.next()) {
	            System.out.println("Invalid Restaurant ID");
	            return;
	        }
			PreparedStatement pstmt3=con.prepareStatement(SELECT_QUERY);
			 pstmt3.setInt(1, m.getMenu_id());

		        ResultSet res1 = pstmt3.executeQuery();

		        if (res1.next()) {

				
			PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY);

			pstmt.setString(1, m.getNameofitem());
			pstmt.setFloat(2, m.getPrice());
			pstmt.setFloat(3, m.getRating());
			pstmt.setString(4, m.getCategory());
			pstmt.setInt(5, m.getRes_id());
			pstmt.setString(6, m.getImgurl());
			pstmt.setInt(7, m.getMenu_id());

			int i = pstmt.executeUpdate();

			System.out.println(i + " row is affected");

		} 
			else {
				System.out.println("invalid");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delteMenu(int menu_id) {
		try {
			PreparedStatement pstmt3=con.prepareStatement(SELECT_QUERY);
			 pstmt3.setInt(1, menu_id);

		        ResultSet res1 = pstmt3.executeQuery();

		        if (res1.next()) {
			PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY);

			pstmt.setInt(1, menu_id);

			int i = pstmt.executeUpdate();

			System.out.println(i + " row is deleted");

		}
		        else {
		        	System.out.println("invalid menu id");
		        }
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Override
	public List<Menu> getAllMenu() {
		List<Menu> list = new ArrayList<>();

		try {

			PreparedStatement pstmt = con.prepareStatement(GETALL_QUERY);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {

				int id = res.getInt("menu_id");
				String name = res.getString("nameofitem");
				float price = res.getFloat("price");
				float rating = res.getFloat("rating");
				String category = res.getString("category");
				int resId = res.getInt("res_id");
				 String imgurl = res.getString("imgurl");

				Menu menu = new Menu(id, name, price, rating, category, resId,imgurl);

				list.add(menu);
			}
			
			
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Menu> getAllMenuByRestaurant(int res_id) {

	    List<Menu> list = new ArrayList<>();

	    try {

	        PreparedStatement pstmt = con.prepareStatement(GET_MENU_BY_RESTAURANT);

	        pstmt.setInt(1, res_id);

	        ResultSet res = pstmt.executeQuery();

	        while (res.next()) {

	            int id = res.getInt("menu_id");
	            String name = res.getString("nameofitem");
	            float price = res.getFloat("price");
	            float rating = res.getFloat("rating");
	            String category = res.getString("category");
	            int restaurantId = res.getInt("res_id");
	            String imgurl = res.getString("imgurl");
	            Menu menu = new Menu(
	                    id,
	                    name,
	                    price,
	                    rating,
	                    category,
	                    restaurantId,
	                    imgurl
	            );

	            list.add(menu);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	public List<Menu> searchMenu(String keyword){

	    List<Menu> list=new ArrayList<>();

	    try{

	        PreparedStatement pstmt=con.prepareStatement(SEARCH_MENU);

	        String search="%"+keyword+"%";

	        pstmt.setString(1,search);
	        pstmt.setString(2,search);

	        ResultSet res=pstmt.executeQuery();

	        while(res.next()){

	            Menu menu=new Menu();

	            menu.setMenu_id(res.getInt("menu_id"));
	            menu.setNameofitem(res.getString("nameofitem"));
	            menu.setPrice(res.getFloat("price"));
	            menu.setRating(res.getFloat("rating"));
	            menu.setCategory(res.getString("category"));
	            menu.setRes_id(res.getInt("res_id"));
	            menu.setImgurl(res.getString("imgurl"));
	            menu.setRestaurantName(res.getString("restaurantName"));

	            list.add(menu);
	        }

	    }catch(Exception e){
	        e.printStackTrace();
	    }

	    return list;
	}
	public void addMenuByAdmin(Menu menu) {

	    try {

	        // Check whether Restaurant ID exists
	        PreparedStatement pstmt1 = con.prepareStatement(SELECT_UQUERY);

	        pstmt1.setInt(1, menu.getRes_id());

	        ResultSet rs = pstmt1.executeQuery();

	        if(rs.next()) {

	            PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY2);

	            pstmt.setString(1, menu.getNameofitem());
	            pstmt.setFloat(2, menu.getPrice());
	            pstmt.setFloat(3, menu.getRating());
	            pstmt.setString(4, menu.getCategory());
	            pstmt.setInt(5, menu.getRes_id());
	            pstmt.setString(6, menu.getImgurl());

	            int i = pstmt.executeUpdate();

	            System.out.println(i + " Menu Added Successfully");

	        }
	        else {

	            System.out.println("Invalid Restaurant ID");

	        }

	    }
	    catch(Exception e) {

	        e.printStackTrace();

	    }

	}
	@Override
	public int getTotalMenuItems(int res_id) {

	    int count = 0;

	    try {

	        PreparedStatement pstmt =
	                con.prepareStatement("SELECT COUNT(*) FROM menu WHERE res_id=?");

	        pstmt.setInt(1, res_id);

	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            count = rs.getInt(1);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return count;
	}
	
}
//}

