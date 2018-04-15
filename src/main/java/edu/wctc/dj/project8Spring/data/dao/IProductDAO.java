
package edu.wctc.dj.project8Spring.data.dao;

// Author David

import edu.wctc.dj.project8Spring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductDAO extends JpaRepository<Product, String>{

}
