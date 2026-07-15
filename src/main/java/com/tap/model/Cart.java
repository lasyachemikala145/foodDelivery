package com.tap.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	Map<Integer,CartItem>items;

	public Cart() {
	items=new HashMap<Integer,CartItem>();
	}
	//create addItem() in the cart class to add cartitem
	public void addItem(CartItem cartitem) {
		int menuId=cartitem.getMenu_id();
//		Key = menu_id
//		Value = CartItem
		if(items.containsKey(menuId)) {
			CartItem existingCartItem=items.get(menuId);
			existingCartItem.setQuantity(existingCartItem.getQuantity());
		}
		items.put(menuId,cartitem);
	}
	public Map<Integer, CartItem> getItems() {
		return items;
	}
	public void setItems(Map<Integer, CartItem> items) {
		this.items = items;
	}
	public void updateItem(int itemId,int quantity) {
		if(items.containsKey(itemId)) {
			if(quantity>0) {
				CartItem existingItem=items.get(itemId);
				existingItem.setQuantity(quantity);
			}
		}
		else {
			items.remove(itemId);
		}
	}
	public void removeItemFromCart(int itemId) {
		items.remove(itemId);
	}
	
}
