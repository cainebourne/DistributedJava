
package edu.wctc.dj.project10Restful.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * new comment
 * @author cainebourne
 */
@Entity
@JsonIgnoreProperties({"hibernatelazyinitializer", "handler"}) 
@Table(name="PRODUCTS")
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productId;
	
	private String productName;
	
	private String description;
	
	private Double price;
	
	public Product(Integer productId,String productName, Double price, String description){
		setProductId(productId);
		setProductName(productName);
		setPrice(price);
		setDescription(description);
	}
	
	public Product(Integer productId,String productName, Double price){
		this(productId,productName,price, "");
	}

	public Product() {
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product{ productId=" + productId + '}';
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.productId);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Product other = (Product) obj;
		if (!Objects.equals(this.productId, other.productId)) {
			return false;
		}
		return true;
	}
	
	
}
