
package edu.wctc.dj.project9SpringBoot.services;


import edu.wctc.dj.project9SpringBoot.data.dao.IProductDAO;
import edu.wctc.dj.project9SpringBoot.model.Product;
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
	
	public List<Product> getAllProducts(){
		return products.findAll();
	}
	
	public List<Product> getProductsThatContain(String search){
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("description", ExampleMatcher.GenericPropertyMatchers.contains());
		Product p = new Product();
		p.setDescription(search);
		return products.findAll(Example.of(p,matcher));
	}
	
	public Product getProductById(String searchId){
		return products.getOne(searchId);
	}
}