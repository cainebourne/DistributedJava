
package edu.wctc.dj.project6.model;

import edu.wctc.dj.project6.data.CustomerDAO;
import edu.wctc.dj.project6.data.ProductsDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author cainebourne
 */
public class ProductService {
    
       public List<Product> getAllProducts() throws Exception{
		ProductsDAO productDAO = new ProductsDAO();
                List<Product> productList = productDAO.getProducts();
                
                if(productList != null){
                     
                    for (Product product : productList){
                       
                        
                    }
                         
                }
    return productList;
	}
	
	public List<Product> getProductsThatContain(String search){
		//todo
                return null;
	}
	
	public Product getProductById(String searchId){
		//todo
                return null;
}}
        
    
//    private final List<Product> products = Arrays.asList(
//			new Product("A01","Motherboard", 100, "Plug everything into this"),
//			new Product("B02","Ram", 50, "Random access memory"),
//			new Product("C03","Processor", 200, "The Brain of your computer"),
//			new Product("D04","Graphics Card", 5000, "For video games and to make the computer very expensive especially now that everyone is crytpo mining")
//	);
//	
//	public List<Product> getAllProducts(){
//		return products;
//	}
//	
//	public List<Product> getProductsThatContain(String search){
//		List<Product> ret = new ArrayList<>();
//		
//		products.stream().filter
//				((prod) -> 
//						(prod.getProductName().contains(search) || prod.getDescription().contains(search))
//				).forEachOrdered((prod) -> {
//									ret.add(prod);
//								});
//		
//		return ret;
//	}
//	
//	public Product getProductById(String searchId){
//		for(Product prod : products){
//			if(prod.getProductId().equals(searchId))
//				return prod;
//		}
//		
//		return null;
//	}
//    
//}