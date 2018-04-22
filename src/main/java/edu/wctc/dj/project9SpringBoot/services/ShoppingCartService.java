
package edu.wctc.dj.project9SpringBoot.services;

import edu.wctc.dj.project9SpringBoot.data.dao.ICustomerDAO;
import edu.wctc.dj.project9SpringBoot.data.dao.IShoppingCartDAO;
import edu.wctc.dj.project9SpringBoot.model.Customer;
import edu.wctc.dj.project9SpringBoot.model.Product;
import edu.wctc.dj.project9SpringBoot.model.ShoppingCart;
import java.util.List;
import java.util.Optional;
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
public class ShoppingCartService {
	
	@Autowired
	private ICustomerDAO customers;
	@Autowired
	private IShoppingCartDAO cart;
	
	public ShoppingCartService(){
	}
	
	public List<ShoppingCart> getShoppingCart(){
		ExampleMatcher cust = ExampleMatcher.matching().withMatcher("CustomerId", ExampleMatcher.GenericPropertyMatchers.exact());
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("Customer", ExampleMatcher.GenericPropertyMatchers.exact());
		ShoppingCart p = new ShoppingCart();
		Customer c = new Customer();
		c.setCustomerId(1);
		p.setCustomer(customers.findOne(Example.of(c, cust)));
		return cart.findAll(Example.of(p, matcher));
	}
	
	public void addItem(Product prod, int amount){
		ExampleMatcher cust = ExampleMatcher.matching().withMatcher("CustomerId", ExampleMatcher.GenericPropertyMatchers.exact());
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("Customer", ExampleMatcher.GenericPropertyMatchers.exact());
		ShoppingCart p = new ShoppingCart();
		Customer c = new Customer();
		c.setCustomerId(1);
		p.setCustomer(customers.findOne(Example.of(c, cust)));
		
		boolean existed = false;
		for(ShoppingCart s : cart.findAll(Example.of(p, matcher))){
			if(s.getProduct().equals(prod)){
				s.setAmount(s.getAmount() + amount);
				existed = true;
			}
		}
		if(!existed){
			System.out.println("customer = " + customers.toString());
			cart.save(new ShoppingCart(prod,customers.findOne(Example.of(c, cust)) , amount));
		}
	}
	
	public void setItem(Product prod, int amount){
		ExampleMatcher cust = ExampleMatcher.matching().withMatcher("CustomerId", ExampleMatcher.GenericPropertyMatchers.exact());
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("Customer", ExampleMatcher.GenericPropertyMatchers.exact());
		ShoppingCart p = new ShoppingCart();
		Customer c = new Customer();
		c.setCustomerId(1);
		p.setCustomer(customers.findOne(Example.of(c, cust)));
		
		boolean existed = false;
		for(ShoppingCart s : cart.findAll(Example.of(p, matcher))){
			if(s.getProduct().equals(prod)){
				s.setAmount( amount);
				existed = true;
			}
		}
		if(!existed){
			cart.save(new ShoppingCart(prod,customers.findOne(Example.of(c, cust)) , amount));
		}
	}
	
	public Integer getAmountForProd(Product prod){
		int ret = 0;
		Optional<ShoppingCart> product = cart.findAll().stream().filter((s) -> s.getCustomer().getCustomerId() == 1).filter((s) -> s.getProduct().equals(prod)).findFirst();
		if(product.isPresent()){
			ret = product.get().getAmount();
		}
		
		return ret;
	}
}
