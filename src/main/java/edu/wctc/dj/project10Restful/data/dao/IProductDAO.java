
package edu.wctc.dj.project10Restful.data.dao;

// Author cainebourne


import edu.wctc.dj.project10Restful.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductDAO extends JpaRepository<Product, Integer>{

}
