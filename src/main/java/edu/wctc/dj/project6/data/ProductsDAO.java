
package edu.wctc.dj.project6.data;

import edu.wctc.dj.project6.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cainebourne
 */
public class ProductsDAO {
    
    public List<Product> getProducts() throws Exception {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            conn = ConnectionUtil.getConnection();
            stmt = conn.prepareStatement("select * from Products");
            rs = stmt.executeQuery();
            
            List<Product> productList = new ArrayList<>();
            while (rs.next()){
                
                String ProductId = rs.getString("ProductId");
                String ProductName = rs.getString("ProductName");
                Double Price = rs.getDouble("Price");
                String Description = rs.getString("Description");
                
                Product product = new Product(ProductId, ProductName, Price, Description);
                
                productList.add(product);
            }
            
            return productList;
        } finally{
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(conn != null) conn.close();
        }
    }

    
}
