package edu.wctc.dj.project6.data;

import edu.wctc.dj.project6.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cainebourne
 */
public class CustomerDAO {
    
     public List<Customer> getCustomers() throws Exception {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            conn = ConnectionUtil.getConnection();
            stmt = conn.prepareStatement("select * from Customer");
            rs = stmt.executeQuery();
            
            List<Customer> customerList = new ArrayList<>();
            while (rs.next()){
                
                String CustomerId = rs.getString("CustomerId");
                String FirstnameName = rs.getString("FirstnameName");
                String LastName = rs.getString("LastName");
                String MiddleName = rs.getString("MiddleName");
                
                Customer customer = new Customer(CustomerId, FirstnameName, LastName, MiddleName);
                
                customerList.add(customer);
            }
            
            return customerList;
        } finally{
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(conn != null) conn.close();
        }
    }

    
}
    

