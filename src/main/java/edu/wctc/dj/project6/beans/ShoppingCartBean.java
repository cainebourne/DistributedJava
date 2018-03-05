
package edu.wctc.dj.project6.beans;

import edu.wctc.dj.project6.model.ShoppingCart;
import edu.wctc.dj.project6.model.ShoppingCartService;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author David
 */
@Named(value = "shoppingCartBean")
@Dependent
@SessionScoped
public class ShoppingCartBean {
	private final ShoppingCartService cartService;
	private ShoppingCart shoppingCart;
	private double total;
	/**
	 * Creates a new instance of ShoppingCartBean
	 */
	public ShoppingCartBean() {
		cartService = new ShoppingCartService();
		setShoppingCart(cartService.getShoppingCart());
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	
	public void setTotal(double total){
		shoppingCart.getProducts().forEach((p) -> {
			this.total += p.getProduct().getPrice() * p.getAmount();
		});
	}
	
	public double getTotal(){
		return total;
	}
	
	public void setShoppingCart(ShoppingCart shoppingCart){
		if(shoppingCart != null)
			this.shoppingCart = shoppingCart;
		setTotal(0);
	}
	
	public String shoppingCart(){
		shoppingCart = cartService.getShoppingCart();
		return "shoppingCart";
	}
}