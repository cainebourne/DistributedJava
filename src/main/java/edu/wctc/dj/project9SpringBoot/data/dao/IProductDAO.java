
package edu.wctc.dj.project9SpringBoot.data.dao;

// Author David


import edu.wctc.dj.project9SpringBoot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductDAO extends JpaRepository<Product, String>{

}
