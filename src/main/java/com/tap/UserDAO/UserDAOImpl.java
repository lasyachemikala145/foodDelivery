package com.tap.UserDAO;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;   
import com.tap.DAO.Userdao;
import com.tap.model.User;
import com.tap.utility.DBConnection;

public class UserDAOImpl implements Userdao {
	private static final String INSERT_QUERY =
            "INSERT INTO user_table(Name,password,email,Adress,role,createDate,lastloginDate,phone) "
                    + "VALUES(?,?,?,?,?,?,?,?)";
	
	private static final String SELECT_QUERY="Select * from user_table where user_id=?";
	private static final String UPDATE_QUERY="UPDATE user_table SET Name=?,password=?,email=?,"
			+"Adress=?, lastLoginDate=?,createDate=? where user_id=?";
	private static final String DELETE_QUERY="DELETE FROM user_table WHERE  user_id=?";
	private static final String SELECT_ALL_QUERY="SELECT * FROM user_table";
	private static final String query = "SELECT * FROM user_table WHERE email = ?";
	private static final String query1 = "SELECT * FROM user_table WHERE email=? AND password=?";
	public Connection con=DBConnection.getConnection();

    @Override
    public void addUser(User user) {


        Connection con = DBConnection.getConnection();

        try {

            PreparedStatement stmt = con.prepareStatement(INSERT_QUERY);

            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getAddress());
            stmt.setString(5, user.getRole());
            stmt.setTimestamp(6,new Timestamp(System.currentTimeMillis()));
            stmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            stmt.setString(8,user.getPhone());

            int i = stmt.executeUpdate();

            System.out.println(i + " row inserted");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    } // addUser method ends here

    @Override
    public User getUser(int user_id) {
    	try {
    		System.out.println("here is the logic :");
    	Connection con=DBConnection.getConnection();
    	User user=null; 
        PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY);
        pstmt.setInt(1, user_id);
        ResultSet res=pstmt.executeQuery();
        while(res.next()) {
        	int id=res.getInt("user_id");
        	String name=res.getString("Name");
        	String password=res.getString("password");
        	String email=res.getString("email");
        	String Adress=res.getString("Adress");
        	String role=res.getString("role");
        	Timestamp CreateDate=res.getTimestamp("createDate");
        	Timestamp lastLoginDate=res.getTimestamp("lastLoginDate");
        	user = new User(id, name, password, email,
                    Adress, role, CreateDate, lastLoginDate);
        	return user;
        	
        }
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    

    @Override
    public void updateUser(User user) {
    	Connection connection =DBConnection.getConnection();
    	try {
    		PreparedStatement pstmt=connection.prepareStatement(UPDATE_QUERY);
    		pstmt.setString(1, user.getUserName());
    		pstmt.setString(2, user.getPassword());
    		pstmt.setString(3, user.getEmail());
    		pstmt.setString(4, user.getAddress());
    		pstmt.setTimestamp(5,new Timestamp(System.currentTimeMillis()));
            pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            //pstmt.setInt(7, user.getUs());
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    }

    @Override
    public void deleteUser(int user_id) {
    	Connection con=DBConnection.getConnection();
    	try {
    	PreparedStatement pstmt=con.prepareStatement(DELETE_QUERY);
    	pstmt.setInt(1,user_id);
    	int i=pstmt.executeUpdate();
    	System.out.println(i+"row effected");
    	
    }catch(SQLException e) {
    	e.printStackTrace();
    }
    }

    @Override
     public List<User> getAllUsers() {
    	List<User> list=new ArrayList<User>();
    	try {
    	Statement stmt=con.createStatement();
    	ResultSet res=stmt.executeQuery(SELECT_ALL_QUERY);
    	while(res.next()) {
    	int user_id=	res.getInt("user_id");
    	String Name=	res.getString("Name");
    	String password=	res.getString("password");
    	String email=	res.getString("email");
    	String Adress=	res.getString("Adress");
    	String role=	res.getString("role");
    	Timestamp createDate = res.getTimestamp("createDate");
    	Timestamp lastloginDate = res.getTimestamp("lastloginDate");
    	User user=new User(user_id,Name,password,email,Adress,role,createDate,lastloginDate);
    	list.add(user);
    		
    	}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
        return list;
    }
  
    public boolean isUserExists(String email) {

        //String query = "SELECT * FROM user_table WHERE email = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public User validateUser(String email, String password) {

        

        try {

            PreparedStatement pstmt = con.prepareStatement(query1);

            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                User user = new User();

                user.setUser(rs.getInt("user_id"));
                user.setUserName(rs.getString("Name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setAddress(rs.getString("Adress"));
                user.setRole(rs.getString("role"));
                user.setCreateDate(rs.getTimestamp("createDate"));
                user.setLastloginDate(rs.getTimestamp("lastloginDate"));
                user.setPhone(rs.getString("phone"));
                System.out.println(rs.getString("phone"));
                System.out.println(user.getPhone());

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public boolean updateAddress(int userId, String address) {

        String UPDATE_ADDRESS =
        		"UPDATE user_table SET Adress=? WHERE user_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pstmt =
                    con.prepareStatement(UPDATE_ADDRESS);

            pstmt.setString(1, address);
            pstmt.setInt(2, userId);

            int result = pstmt.executeUpdate();

            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    
}
   

