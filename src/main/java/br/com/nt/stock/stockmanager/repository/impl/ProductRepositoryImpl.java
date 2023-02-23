/**
 * 
 */
package br.com.nt.stock.stockmanager.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.nt.stock.stockmanager.model.Product;
import br.com.nt.stock.stockmanager.repository.ProductRepository;

/**
 * @author Neto
 *
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Optional<Product> findById(Long id) {
		String sql = "SELECT id, name, description, price, amount FROM product WHERE id = ?";
		return jdbcTemplate.query(sql, new ProdutoRowMapper(), id).stream().findFirst();
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(Product product) {
		String sql = "INSERT INTO product (name, description, price, amount) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, product.getName(), product.getDescription(), product.getPrice(), product.getPrice());

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	class ProdutoRowMapper implements RowMapper<Product> {
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setId(rs.getLong("id"));
			product.setName(rs.getString("name"));
			product.setDescription(rs.getString("description"));
			product.setPrice(rs.getBigDecimal("price"));
			product.setAmount(rs.getInt("amount"));
			return product;
		}
	}
}
