package edu.wctc.dj.model;

/**
 *
 * @author Cainebourne
 */
public class Product {
    
    private String id;
    private String productName;

    public Product(String id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    
}
