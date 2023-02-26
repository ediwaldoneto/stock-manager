/**
 * 
 */
package br.com.nt.stock.stockmanager.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nt.stock.stockmanager.model.Product;
import br.com.nt.stock.stockmanager.repository.ProductRepository;
import br.com.nt.stock.stockmanager.service.ProductService;

/**
 * @author Neto
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public void save(Product product) {
		productRepository.save(product);
	}

	@Override
	public void update(Product product) {
		productRepository.update(product);
	}

	@Override
	public void delete(Long id) {
		productRepository.delete(id);
	}

}
