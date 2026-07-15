package com.tap.DAO;

import java.util.List;
import com.tap.model.User;

public interface Userdao {

    void addUser(User user);
    
    User getUser(int user_id);

    void updateUser(User user);

    void deleteUser(int user_id);

    List<User> getAllUsers();
    User validateUser(String email, String password);
    boolean isUserExists(String email);
}