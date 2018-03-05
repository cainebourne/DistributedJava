
package edu.wctc.dj.project6.beans;

import edu.wctc.dj.project6.model.Product;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import edu.wctc.dj.project6.model.ProductService;
import java.io.IOException;
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
public final class ProductBean {
	@ManagedProperty(name="searchString", value="")
	private	String searchString;
	@ManagedProperty(name="searchId", value="")
	private String searchId;
	private final ProductService productService = new ProductService();
	@ManagedProperty(name="products", value="")
	private List<Product> products;
	@ManagedProperty(name="product", value="")
	private Product product;
	
	/**
	 * Creates a new instance of ProductBean
	 */
	public ProductBean() {
		setProducts(productService.getAllProducts());
		System.out.println("new Bean");
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

	public void setProduct(Product prod) {
		if(prod != null)
			product = prod;
		System.out.println("product = " + product);
	}

	public String getSearchString() {
		return searchString;
	}
	
	public void setSearchId(String search) {
		if(search != null && !search.isEmpty())
			searchId = search;
		System.out.println(search + " = searchId");
	}

	public void setSearchString(String search) {
		if(search != null)
			searchString = search;
		System.out.println("searchString = " + searchString);
	}

	public String getSearchId() {
		System.out.println("getting searchId");
		System.out.println(searchId);
		return searchId;
	}

	
	public String searchProducts(){
		setProducts(productService.getProductsThatContain(searchString));
		return "productList";
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
			FacesContext.getCurrentInstance().getExternalContext().redirect("/Project6/productInfo.xhtml");
		}catch(IOException e){
			FacesMessage message = new FacesMessage("IOException", product.getProductId());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
}
