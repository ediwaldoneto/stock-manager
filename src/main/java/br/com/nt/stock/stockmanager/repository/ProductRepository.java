/**
 * 
 */
package br.com.nt.stock.stockmanager.repository;

import java.util.List;
import java.util.Optional;

import br.com.nt.stock.stockmanager.model.Product;

/**
 * @author Neto
 *
 */
public interface ProductRepository {

	/**
	 * This is the method to use to search by id a record in the Product table.
	 */
	public Optional<Product> findById(final Long id);

	/**
	 * This is the method to be used to list down all the records from the Product
	 * table.
	 */
	public List<Product> findAll();

	/**
	 * This is the method to be used to update a record into the Product table.
	 */
	public void update(final Product product);

	/**
	 * This is the method to use to create a record in the Product table
	 */
	public void save(final Product product);

	/**
	 * This is the method to be used to delete a record from the Product table
	 * corresponding to a passed student id.
	 */
	public void delete(final Long id);
}
