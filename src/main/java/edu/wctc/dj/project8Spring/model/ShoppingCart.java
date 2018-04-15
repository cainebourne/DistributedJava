
package edu.wctc.dj.project8Spring.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author cainebourne
 */
@Entity
@Table(name="ShoppingCart")
public class ShoppingCart implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String shoppingCartId;
	
	@OneToOne
	@JoinColumn(name="FKProductId")
	private Product product;
	
	@OneToOne
	@JoinColumn(name="FKCustomerId")
	private Customer customer;
	
	private Integer amount;
	
	public ShoppingCart(){
	}
	
	public ShoppingCart(Product p, Customer c, Integer amount){
		this.setProduct(p);
		this.setCustomer(c);
		this.setAmount(amount);
	}

	public String getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(String shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ShoppingCart{" + "shoppingCartId=" + shoppingCartId + ", product=" + product + ", customer=" + customer + ", amount=" + amount + '}';
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 11 * hash + Objects.hashCode(this.shoppingCartId);
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
		final ShoppingCart other = (ShoppingCart) obj;
		if (!Objects.equals(this.shoppingCartId, other.shoppingCartId)) {
			return false;
		}
		return true;
	}
	
}

