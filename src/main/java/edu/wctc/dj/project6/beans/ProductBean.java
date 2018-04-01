
package edu.wctc.dj.project6.beans;

import edu.wctc.dj.project6.model.Product;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import edu.wctc.dj.project6.model.ProductService;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
/**
 *
 * @author cainebourne
 */
@SessionScoped
@ManagedBean(name="productBean")
@Dependent
public final class ProductBean implements Serializable{
	private	String searchString;
	private String searchId;
	private final ProductService productService = new ProductService();
	private List<Product> products;
	private Product product;
	private List<Product> searchedProducts;
	private boolean adding = false;
	
	/**
	 * Creates a new instance of ProductBean
	 */
	public ProductBean() {
		setProducts(productService.getAllProducts());
		System.out.println("new Bean");
	}

	public List<Product> getSearchedProducts() {
		return searchedProducts;
	}

	public void setSearchedProducts(List<Product> searchedProducts) {
		this.searchedProducts = searchedProducts;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> prod) {
		if(prod != null)
			products = prod;
		System.out.println("products = " + products);
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
	
	public void setSearchId(String search) {
		System.out.println(search + " = searchId");
	}

	public void setSearchString(String search) {
		searchString = search;
	}

	public String getSearchId() {
		return searchId;
	}

	
	public String searchProducts(){
		setSearchedProducts(productService.getProductsThatContain(searchString));
		if(this.searchedProducts == null )
			return "productList";
		if(this.searchedProducts.isEmpty())
			return "productList";
		return "productSearch";
	}
	
	public String searchProductsById(){
//		if(searchId == null)
//			searchId = "S001";
		System.out.println(searchId);
		setProduct(productService.getProductById(searchId));
		System.out.println(product);
		if(product == null)
			return "productList";
		return "productInfo";
	}
	
	public String allProducts(){
		return "productList";
	}
	
	public void productDetail(AjaxBehaviorEvent event){
		try{
			FacesContext.getCurrentInstance().getExternalContext().redirect("/Project7/productInfo.xhtml");
		}catch(IOException e){
			FacesMessage message = new FacesMessage("IOException", product.getProductId());
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
