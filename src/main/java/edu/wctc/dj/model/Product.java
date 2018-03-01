
package edu.wctc.dj.model;

/**
 *
 * @author cainebourne
 */
public class Product {
    
private final String NO_DESCRIPTION = "No description available";
	private String productId,productName, description;
	private double price;
	
	public Product(String productId,String productName, double price, String description){
		setProductId(productId);
		setProductName(productName);
		setPrice(price);
		setDescription(description);
	}
	
	public Product(String productId,String productName, double price){
		this(productId,productName,price, "");
	}

	public String getProductName() {
		return productName;
	}

	public final void setProductName(String productName) {
		this.productName = productName;
	}

	public final String getProductId() {
		return productId;
	}

	public final void setProductId(String productId) {
		this.productId = productId;
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(String description) {
		this.description = description;
	}

	public final double getPrice() {
		return price;
	}

	public final void setPrice(double price) {
		this.price = price;
	}
	
}