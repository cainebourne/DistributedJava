
package edu.wctc.dj.project6.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author cainebourne
 */
public class ProductService {
    
        private final List<Product> products = Arrays.asList(
			new Product("A01","Motherboard", 100, "Plug everything into this"),
			new Product("B02","Ram", 50, "Random access memory"),
			new Product("C03","Processor", 200, "The Brain of your computer"),
			new Product("D04","Graphics Card", 5000, "For video games and to make the computer very expensive especially now that everyone is crytpo mining")
	);
	
	public List<Product> getAllProducts(){
		return products;
	}
	
	public List<Product> getProductsThatContain(String search){
		List<Product> ret = new ArrayList<>();
		
		products.stream().filter
				((prod) -> 
						(prod.getProductName().contains(search) || prod.getDescription().contains(search))
				).forEachOrdered((prod) -> {
									ret.add(prod);
								});
		
		return ret;
	}
	
	public Product getProductById(String searchId){
		for(Product prod : products){
			if(prod.getProductId().equals(searchId))
				return prod;
		}
		
		return null;
	}
}
