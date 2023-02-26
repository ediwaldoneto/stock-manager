/**
 * 
 */
package br.com.nt.stock.stockmanager.dto.model;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;

import br.com.nt.stock.stockmanager.model.Product;

/**
 * @author Neto
 *
 */
public class ProductDTO {

	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	private int amount;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * Method to convert an Product DTO to a Product entity.
	 * 
	 * @param dto
	 * @return a <code>Product</code> object
	 */
	public Product convertDTOToEntity() {
		return new ModelMapper().map(this, Product.class);
	}
}
