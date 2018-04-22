
package edu.wctc.dj.project9SpringBoot.beans;


import edu.wctc.dj.project9SpringBoot.model.Product;
import edu.wctc.dj.project9SpringBoot.model.ShoppingCart;
import edu.wctc.dj.project9SpringBoot.services.ShoppingCartService;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author cainebourne
 */
@Component("shoppingCartBean")
@Scope("session")
public final class ShoppingCartBean implements Serializable{
	@Autowired
	private ShoppingCartService cartService;
	
	private String currentProductId;
	private double total;
	private Integer amount;
	private Product product;
	/**
	 * Creates a new instance of ShoppingCartBean
	 */
	public ShoppingCartBean() {
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		System.out.println("setting Amount");
		this.amount = amount;
		System.out.println("new amount = " + this.amount);
	}

	public List<ShoppingCart> getShoppingCart() {
		return cartService.getShoppingCart();
	}

	public String getCurrentProductId() {
		return currentProductId;
	}
	
	public void setTotal(){
		this.total = 0;
		getShoppingCart().stream().filter((s) -> (s.getCustomer().getCustomerId() == 1)).forEachOrdered((s) -> {
			total += s.getProduct().getPrice() * s.getAmount();
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
			FacesContext.getCurrentInstance().getExternalContext().redirect("/Project8Spring/ProductList");
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

	public Integer getAmountFor(Product p){
		return cartService.getAmountForProd(p);
	}
}