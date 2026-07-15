package com.tap.DAO;


import java.util.List;

import com.tap.model.Menu;

public interface Menudao {
    void addMenu(Menu m);
    Menu getMenu(int menu_id);
    void updateMenu(Menu m);
    void delteMenu(int menu_id );
    List<Menu> getAllMenu();void addMenuByAdmin(Menu m);
    int getTotalMenuItems(int res_id);
	

}
