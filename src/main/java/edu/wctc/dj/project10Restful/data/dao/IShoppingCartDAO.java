package edu.wctc.dj.project10Restful.data.dao;


import edu.wctc.dj.project10Restful.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author cainebourne
 */
public interface IShoppingCartDAO extends JpaRepository<ShoppingCart, Integer>{

}
