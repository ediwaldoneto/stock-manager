/**
 * 
 */
package br.com.nt.stock.stockmanager.service;

import java.util.List;
import java.util.Optional;

import br.com.nt.stock.stockmanager.model.Product;

/**
 * @author Neto
 *
 */
public interface ProductService {

	/**
	 * 
	 * @param id
	 * @return user
	 */
	public Optional<Product> findById(final Long id);

	/**
	 * 
	 * @return List of all users
	 */
	public List<Product> findAll();

	/**
	 * 
	 * @param product
	 */
	public void save(final Product product);

	/**
	 * 
	 * @param product
	 */
	public void update(final Product product);

	/**
	 * 
	 * @param id
	 */
	public void delete(final Long id);

}
