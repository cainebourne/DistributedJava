
package edu.wctc.dj.project6.model;

/**
 * new comment
 * @author cainebourne
 */
public final class Product {
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

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product{" + "NO_DESCRIPTION=" + NO_DESCRIPTION + ", productId=" + productId + ", productName=" + productName + ", description=" + description + ", price=" + price + '}';
	}
	
	
}
