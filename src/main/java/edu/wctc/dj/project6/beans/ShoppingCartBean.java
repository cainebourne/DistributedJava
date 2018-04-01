
package edu.wctc.dj.project6.beans;

import edu.wctc.dj.project6.model.Product;
import edu.wctc.dj.project6.model.ShoppingCart;
import edu.wctc.dj.project6.model.ShoppingCartService;
import java.io.IOException;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author David
 */
@SessionScoped
@ManagedBean(name = "shoppingCartBean")
@Dependent
public final class ShoppingCartBean implements Serializable{
	private final ShoppingCartService cartService;
	private String currentProductId;
	private double total;
	private Integer amount;
	private Product product;
	/**
	 * Creates a new instance of ShoppingCartBean
	 */
	public ShoppingCartBean() {
		cartService = new ShoppingCartService();
		setTotal();
		System.out.println("new Shopping CART");
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		System.out.println("setting Amount");
		this.amount = amount;
		System.out.println("new amount = " + this.amount);
	}

	public ShoppingCart getShoppingCart() {
		return cartService.getShoppingCart();
	}

	public String getCurrentProductId() {
		return currentProductId;
	}
	
	public void setTotal(){
		this.total = 0;
		getShoppingCart().getProducts().forEach((p) -> {
			this.total += p.getPrice() * getShoppingCart().getQuantityFor(p);
		});
	}
	
	public double getTotal(){
		return total;
	}
	
	public String shoppingCart(){
		return "shoppingCart";
	}
	
	public Product getProduct(){
		return product;
	}
	
	public void setProduct(Product prod){
		this.product = prod;
	}
	
	public void addToCart(AjaxBehaviorEvent event){
		System.out.println("Attempting add amount = " + this.amount + "product = " + this.product);
		if(this.amount == null)
			throw new IllegalArgumentException("Amount null :(");
		
		if(this.product == null)
			throw new IllegalArgumentException("Product null :(");
		
		this.cartService.addItem(product, this.amount);
		try{
			FacesContext.getCurrentInstance().getExternalContext().redirect("/Project7/productList.xhtml");
		}catch(IOException e){
			FacesMessage message = new FacesMessage("IOException", product.getProductId());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public void newAmount(ValueChangeEvent e){
		System.out.println("New Value = " + e.getNewValue());
		this.setAmount(Integer.valueOf(e.getNewValue().toString()));
		throw new IllegalArgumentException("Amount set!");
	}
}