
package edu.wctc.dj.project6.model;

/**
 *
 * @author cainebourne
 */
public class ShoppingCartService {
    
private ShoppingCart cart = new ShoppingCart(
		new CartProduct(new Product("A01","Motherboard", 100, "Plug everything into this"), 4),
		new CartProduct(new Product("B02","Ram", 50, "Random access memory"), 2),
		new CartProduct(new Product("C03","Processor", 200, "The Brain of your computer"),3),
		new CartProduct(new Product("D04","Graphics Card", 5000, "For video games and to make the computer very expensive especially now that everyone is crytpo mining"),6)
	);
	
	public ShoppingCartService(){
	}
	
	public ShoppingCart getShoppingCart(){
		return cart;
	}
}
