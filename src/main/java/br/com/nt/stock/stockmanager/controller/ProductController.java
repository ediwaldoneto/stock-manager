/**
 * 
 */
package br.com.nt.stock.stockmanager.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nt.stock.stockmanager.dto.model.ProductDTO;
import br.com.nt.stock.stockmanager.dto.reponse.Response;
import br.com.nt.stock.stockmanager.model.Product;
import br.com.nt.stock.stockmanager.service.ProductService;

/**
 * @author Neto
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	
	@GetMapping("/{id}")
	public ResponseEntity<Response<ProductDTO>> findById(@PathVariable("id") final Long id) {

		Response<ProductDTO> response = new Response<>();
		Optional<Product> product = productService.findById(id);

		if (product.isPresent()) {
			ModelMapper modelMapper = new ModelMapper();
			ProductDTO dto = modelMapper.map(product.get(), ProductDTO.class);
			response.setData(dto);
		} else {
			/**
			 * here it will be implemented if the product is not found
			 */
		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}
