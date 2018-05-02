
package edu.wctc.dj.project10Restful.rest;

// Author cainebourne

import edu.wctc.dj.project10Restful.model.Product;
import edu.wctc.dj.project10Restful.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductService products;
	
	@RequestMapping(method = POST, path = "/products")
	public void createName(@RequestBody Product product){
		products.addProduct(product);
	}
	
	@RequestMapping(method = GET, path = "/products")
	public List<Product> getAllProducts(){
		return products.getAllProducts();
	}
	
	@RequestMapping(method = GET, path ="/products/search/{string}")
	public List<Product> getNamesSimilarTo(@PathVariable String string){
		return products.getProductsThatContain(string);
	}
	
	@RequestMapping(method = GET, path = "/products/{id}")
	public Product getProductById(@PathVariable Integer id){
		return products.getProductById(id);
	}
	
	
	
}

	
	
	

