
package edu.wctc.dj.project10Restful.services;


import edu.wctc.dj.project10Restful.data.dao.IProductDAO;
import edu.wctc.dj.project10Restful.model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cainebourne
 */
@Service
@Transactional
public class ProductService{
	
	@Autowired
	private IProductDAO products;
	
	public ProductService(){
	}
	
	public void addProduct(Product toAdd){
		products.save(toAdd);
	}
	
	public List<Product> getAllProducts(){
		return products.findAll();
	}
	
	public List<Product> getProductsThatContain(String search){
		ExampleMatcher matcher = ExampleMatcher.matchingAny().withMatcher("description", ExampleMatcher.GenericPropertyMatchers.ignoreCase().contains()).withMatcher("productName", ExampleMatcher.GenericPropertyMatchers.ignoreCase().contains());
		Product p = new Product();
		p.setDescription(search);
		p.setProductName(search);
		
		return products.findAll(Example.of(p,matcher));
	}
	
	public Product getProductById(Integer searchId){
		return products.getOne(searchId);
	}
}