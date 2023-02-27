/**
 * 
 */
package br.com.nt.stock.stockmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.nt.stock.stockmanager.dto.reponse.Response;

/**
 * @author Neto
 *
 */
@ControllerAdvice
public class ProductApiException<T> {

	/**
	 * 
	 * @param exception
	 * @return ResponseEntity<Response<T>>
	 */
	@ExceptionHandler(value = { ProductNotFoundException.class })
	protected ResponseEntity<Response<T>> handleTravelNotFoundException(ProductNotFoundException exception) {

		Response<T> response = new Response<>();
		response.addErrorToResponse(exception.getLocalizedMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
}
