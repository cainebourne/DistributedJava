
package edu.wctc.dj.project10Restful.beans;


import edu.wctc.dj.project10Restful.model.Product;
import edu.wctc.dj.project10Restful.services.ProductService;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/**
 *
 * @author cainebourne
 */
@Component("productBean")
@Scope("session")
public final class ProductBean implements Serializable{
	private	String searchString;
	private Integer searchId;
	
	@Autowired
	private ProductService productService;
	
	private Product product;
	private boolean adding = false;
	
	/**
	 * Creates a new instance of ProductBean
	 */
	public ProductBean() {
		System.out.println("new bean");
	}

	public List<Product> getSearchedProducts() {
		return productService.getProductsThatContain(searchString);
	}

	public List<Product> getProducts() {
		return productService.getAllProducts();
	}
	

	public Product getProduct() {
		return product;
	}

	public boolean isAdding() {
		return adding;
	}

	public void setAdding(boolean adding) {
		this.adding = adding;
	}

	public void setProduct(Product prod) {
		product = prod;
		System.out.println("product = " + product);
	}

	public String getSearchString() {
		return searchString;
	}
	
	public void setSearchId(Integer search) {
		System.out.println(search + " = searchId");
		this.searchId = search;
	}

	public void setSearchString(String search) {
		System.out.println("searchString = " + search);
		searchString = search;
	}
	
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	public Integer getSearchId() {
		return searchId;
	}

	
	public String searchProducts(){
		List<Product> searchedProducts = getSearchedProducts();
		if(searchedProducts == null || searchedProducts.isEmpty())
			return "ProductList";
		System.out.println("ProductSearch \n\n\n\n\n\n\n\n");
		return "ProductSearch";
	}
	
	public String searchProductsById(){
		System.out.println("searchId = " + getSearchId());
		setProduct(productService.getProductById(searchId));
		if(product == null)
			return "productList";
		System.out.println("returning product info");
		return "productInfo";
	}
	
	public String allProducts(){
		return "ProductList";
	}
	
	public void productDetail(AjaxBehaviorEvent event){
		System.out.println("ajax");
		try{
			System.out.println("redirect");
			FacesContext.getCurrentInstance().getExternalContext().redirect("ProductInfo");
			System.out.println("redirect over");
		}catch(IOException e){
			FacesMessage message = new FacesMessage("IOException", product.getProductId().toString());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	public void startAdding(AjaxBehaviorEvent event){
		adding=true;
	}
	
	public void stopAdding(AjaxBehaviorEvent event){
		adding=false;
	}
	
}
