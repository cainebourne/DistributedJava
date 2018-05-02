
package edu.wctc.dj.project10Restful.data.dao;

// Author cainebourne


import edu.wctc.dj.project10Restful.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerDAO extends JpaRepository<Customer, Integer> {

}
