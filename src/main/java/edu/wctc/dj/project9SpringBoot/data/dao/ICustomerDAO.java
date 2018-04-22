
package edu.wctc.dj.project9SpringBoot.data.dao;

// Author cainebourne


import edu.wctc.dj.project9SpringBoot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerDAO extends JpaRepository<Customer, Integer> {

}
