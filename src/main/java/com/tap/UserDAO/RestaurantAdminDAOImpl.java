package com.tap.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tap.DAO.RestaurantAdminDAO;
import com.tap.model.RestaurantAdmin;
import com.tap.utility.DBConnection;

public class RestaurantAdminDAOImpl implements RestaurantAdminDAO {

    private static final String LOGIN_QUERY =
            "SELECT * FROM restaurant_admin WHERE email=? AND password=?";
    private static final String INSERT_ADMIN =
    		"INSERT INTO restaurant_admin(restaurant_id,name,email,password) VALUES(?,?,?,?)";

    Connection con = DBConnection.getConnection();

    @Override
    public RestaurantAdmin validateAdmin(String email, String password) {

        RestaurantAdmin admin = null;

        try {

            PreparedStatement pstmt = con.prepareStatement(LOGIN_QUERY);

            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {

                admin = new RestaurantAdmin();

                admin.setAdmin_id(rs.getInt("admin_id"));
                admin.setRestaurant_id(rs.getInt("restaurant_id"));
                admin.setName(rs.getString("name"));
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("password"));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }public void addAdmin(RestaurantAdmin admin) {

        try {

            PreparedStatement pstmt = con.prepareStatement(INSERT_ADMIN);

            pstmt.setInt(1, admin.getRestaurant_id());
            pstmt.setString(2, admin.getName());
            pstmt.setString(3, admin.getEmail());
            pstmt.setString(4, admin.getPassword());

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean isRestaurantAlreadyAssigned(int restaurantId) {

        String CHECK_QUERY =
                "SELECT * FROM restaurant_admin WHERE restaurant_id=?";

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(CHECK_QUERY);

            pstmt.setInt(1, restaurantId);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                return true;

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }
}