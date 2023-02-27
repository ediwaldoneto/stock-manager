/**
 * 
 */
package br.com.nt.stock.stockmanager.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
     * 
     * 200 - OK: Everything worked as expected.
	 * 400 - Bad Request: The request was unacceptable, often due to missing a required parameter.
	 * 404 - Not Found: The requested resource doesn't exist.
	 * 409 - Conflict: The request conflicts with another request (perhaps due to using the same idempotent key).
	 * 429 - Too Many Requests: Too many requests hit the API too quickly. We recommend an exponential back-off of your requests.
	 * 500, 502, 503, 504 - Server Errors: something went wrong on API end.
     * @throws ProductNotFoundException 
     */
	@GetMapping("/{id}")
	public ResponseEntity<Response<ProductDTO>> findById(@PathVariable("id") final Long id) throws ProductNotFoundException {

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
	 * 201 - Created: Everything worked as expected.
	 * 400 - Bad Request: The request was unacceptable, often due to missing a required parameter.
	 * 404 - Not Found: The requested resource doesn't exist.
	 * 409 - Confli* 201 - Created: Everything worked as expected.ct: The request conflicts with another request (perhaps due to using the same idempotent key).
	 * 429 - Too Many Requests: Too many requests hit the API too quickly. We recommend an exponential back-off of your requests.
	 * 500, 502, 503, 504 - Server Errors: something went wrong on API end.
	 */
	@PostMapping
	public ResponseEntity<Response<ProductDTO>> create(@RequestBody @Valid final ProductDTO dto,  BindingResult result){
		
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
}
