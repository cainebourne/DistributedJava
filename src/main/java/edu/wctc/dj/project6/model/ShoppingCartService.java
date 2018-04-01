
package edu.wctc.dj.project6.model;

import java.util.HashMap;

/**
 *
 * @author cainebourne
 */
public class ShoppingCartService {
	private final ShoppingCart cart;
	
	public ShoppingCartService(){
		cart = new ShoppingCart(new HashMap<>());
	}
	
	public ShoppingCart getShoppingCart(){
		return cart;
	}
	
	public void addItem(Product prod, int amount){
		cart.addProduct(prod, amount);
	}
	
	public void setItem(Product prod, int amount){
		cart.setProduct(prod, amount);
	}
}
