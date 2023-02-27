/**
 * 
 */
package br.com.nt.stock.stockmanager.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nt.stock.stockmanager.dto.model.ProductDTO;
import br.com.nt.stock.stockmanager.dto.reponse.Response;
import br.com.nt.stock.stockmanager.exception.ProductNotFoundException;
import br.com.nt.stock.stockmanager.model.Product;
import br.com.nt.stock.stockmanager.service.ProductService;
import jakarta.validation.Valid;

/**
 * @author Neto
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * 
	 * @param id
	 * @return ResponseEntity with a Response ProductDTO object and the HTTP status
	 *
	 * @throws ProductNotFoundException
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Response<ProductDTO>> findById(@PathVariable("id") final Long id)
			throws ProductNotFoundException {

		Response<ProductDTO> response = new Response<>();
		Optional<Product> product = productService.findById(id);

		if (!product.isPresent()) {
			throw new ProductNotFoundException("no match found for id");
		}

		ModelMapper modelMapper = new ModelMapper();
		ProductDTO dto = modelMapper.map(product.get(), ProductDTO.class);
		response.setData(dto);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	/**
	 * 
	 * @param dto
	 * @return
	 * 
	 * 
	 */
	@PostMapping
	public ResponseEntity<Response<ProductDTO>> create(@RequestBody @Valid final ProductDTO dto, BindingResult result) {

		Response<ProductDTO> response = new Response<>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.addErrorToResponse(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Product product = dto.convertDTOToEntity();
		productService.save(product);
		response.setData(dto);

		return new ResponseEntity<>(response, HttpStatus.CREATED);

	}

	/**
	 * 
	 * @param dto
	 * @throws ProductNotFoundException
	 */
	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<ProductDTO>> update(@RequestBody @Valid final ProductDTO dto, BindingResult result)
			throws ProductNotFoundException {

		Response<ProductDTO> response = new Response<>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.addErrorToResponse(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Optional<Product> product = productService.findById(dto.getId());

		if (!product.isPresent()) {
			throw new ProductNotFoundException("id not found in database for update");
		}
		productService.update(dto.convertDTOToEntity());
		response.setData(dto);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	/**
	 * 
	 * 
	 * @return
	 * @throws ProductNotFoundException
	 */
	@GetMapping
	public ResponseEntity<Response<List<ProductDTO>>> findAll() throws ProductNotFoundException {

		Response<List<ProductDTO>> response = new Response<>();

		List<ProductDTO> productDTOs = new ArrayList<>();
		List<Product> products = productService.findAll();

		if (products.isEmpty()) {
			throw new ProductNotFoundException("No occurrence found in the database");
		}

		products.stream().forEach(t -> productDTOs.add(t.convertEntityToDTO()));
		response.setData(productDTOs);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
