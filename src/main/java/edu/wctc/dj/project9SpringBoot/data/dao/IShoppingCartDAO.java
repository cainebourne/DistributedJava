package edu.wctc.dj.project9SpringBoot.data.dao;


import edu.wctc.dj.project9SpringBoot.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author cainebourne
 */
public interface IShoppingCartDAO extends JpaRepository<ShoppingCart, Integer>{

}
