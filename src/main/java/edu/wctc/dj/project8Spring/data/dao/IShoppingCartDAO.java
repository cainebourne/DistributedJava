package edu.wctc.dj.project8Spring.data.dao;

import edu.wctc.dj.project8Spring.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author David
 */
public interface IShoppingCartDAO extends JpaRepository<ShoppingCart, Integer>{

}
