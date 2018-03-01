
package edu.wctc.dj.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author cainebourne
 */
public class ShoppingCart {
    
private List<CartProduct> products;
	
	public ShoppingCart(List<CartProduct> products){
		setProducts(products);
	}
	
	public ShoppingCart(CartProduct... a){
		products = new ArrayList<>();
		setProducts(Arrays.asList(a));
	}
	
	public List<CartProduct> getProducts() {
		return products;
	}

	public void setProducts(List<CartProduct> products) {
		if(products == null)
			throw new IllegalArgumentException("Products cannot be null when setting a shopping cart");
		this.products = products;
	}
	
	public void addProduct(Product p, int quan){
		products.add(new CartProduct(p, quan));
	}
}

