package com.tap.DAO;

import com.tap.model.RestaurantAdmin;

public interface RestaurantAdminDAO {
	RestaurantAdmin validateAdmin(String email, String password);

}
