package edu.wctc.dj.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Cainebourne
 */
public class ProductService {
    
private List<Product> productList = Arrays.asList(
		new Product("1", "Product1"),
		new Product("2", "Product2"),
                new Product("2", "Product3")
	);

	public Product getProduct(String id) {
		Product theProduct = null;

		for (Product product : productList) {
			if (product.getId().equals(id)) {
				theProduct = product;
			}
		}

		return theProduct;
	}

	public List<Product> getAllProducts(){
		return productList;
	}

	public List<Product> findNames(String search) {
		search = search.toLowerCase();
		List<Product> theList = new ArrayList<>();
		for (Product product : productList) {
			if (product.getProductName().toLowerCase().startsWith(search) ) 
                        {
				theList.add(product);
			}
		}
		return theList;
	}
	
}


