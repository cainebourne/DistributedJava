
package edu.wctc.dj.model;

/**
 *
 * @author cainebourne
 */
public class CartProduct {
    
private Product product;
	private int amount;
	
	public CartProduct(Product prod, int amount){
		setProduct(prod);
		setAmount(amount);
	}

	public Product getProduct() {
		return product;
	}

	private void setProduct(Product product) {
		
		if(product == null)
			throw new IllegalArgumentException("Product cannot be null when creating a CartProduct");
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
