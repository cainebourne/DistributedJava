
package edu.wctc.dj.project8Spring.data.dao;

// Author cainebourne

import edu.wctc.dj.project8Spring.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerDAO extends JpaRepository<Customer, Integer> {

}
