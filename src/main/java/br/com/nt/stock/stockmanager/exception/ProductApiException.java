/**
 * 
 */
package br.com.nt.stock.stockmanager.exception;

import java.sql.SQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ServerErrorException;

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
	protected ResponseEntity<Response<T>> handleProductNotFoundException(ProductNotFoundException exception) {

		Response<T> response = new Response<>();
		response.addErrorToResponse(exception.getLocalizedMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	/**
	 * 
	 * @param exception
	 * @return ResponseEntity<Response<T>>
	 */
	@ExceptionHandler(value = { ServerErrorException.class })
	protected ResponseEntity<Response<T>> handleAPIException(ServerErrorException exception) {

		Response<T> response = new Response<>();
		response.addErrorToResponse(exception.getLocalizedMessage());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}

	/**
	 * 
	 * @param exception
	 * 
	 * @return ResponseEntity<Response<T>>
	 */
	@ExceptionHandler(value = { MethodArgumentTypeMismatchException.class })
	protected ResponseEntity<Response<T>> handleAPIMethodArgumentTypeMismatchException(
			MethodArgumentTypeMismatchException exception) {

		Response<T> response = new Response<>();
		response.addErrorToResponse(exception.getLocalizedMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	/**
	 * @param exception
	 * 
	 * @return ResponseEntity<Response<T>>
	 */
	@ExceptionHandler(value = { SQLException.class })
	protected ResponseEntity<Response<T>> handleAPISQLException(SQLException exception) {

		Response<T> response = new Response<>();
		response.addErrorToResponse(exception.getLocalizedMessage());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}
