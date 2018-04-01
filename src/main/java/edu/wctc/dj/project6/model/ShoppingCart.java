
package edu.wctc.dj.project6.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * @author cainebourne
 */
public final class ShoppingCart {
	private Map<Product, Integer> products;
	
	public ShoppingCart(Map<Product, Integer> products){
		setProducts(products);
	}
	
	public List<Product> getProducts() {
		return new ArrayList(products.keySet());
	}

	public int getQuantityFor(Product p){
		int ret = products.get(p) == null ? 0 : products.get(p);
		return ret;
	}
	
	public void setProducts(Map<Product, Integer> products) {
		if(products == null)
			throw new IllegalArgumentException("Products cannot be null when setting a shopping cart");
		this.products = products;
	}
	
	public void setProduct(Product p, int quan){
		products.put(p, quan);
	}
	
	public void addProduct(Product p, int quan){
		System.out.println("product in add in Cart = " + p + "\n quan = " + quan);
		if(products.containsKey(p))
			products.put(p, products.get(p) + quan);
		else
			products.put(p, quan);
	}
}

