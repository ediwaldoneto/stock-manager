/**
 * 
 */
package br.com.nt.stock.stockmanager.dto.model;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import br.com.nt.stock.stockmanager.model.Product;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

/**
 * @author Neto
 *
 */
public class ProductDTO {

	private Long id;
	@NotNull(message = "Name cannot be null.")
	@Length(min = 3, max = 255, message = "Name must contain between 3 and 255 characters.")
	private String name;
	@NotNull(message = "Description cannot be null.")
	private String description;
	@NotNull(message = "Price cannot be null.")
	@DecimalMin(value = "0.01", message = "Price must be greater than or equal to 0.01")
	private BigDecimal price;
	@NotNull(message = "Amount cannot be null.")
	@PositiveOrZero(message = "Quantity must be greater than or equal to 0")
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
