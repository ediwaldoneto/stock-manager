/**
 * 
 */
package br.com.nt.stock.stockmanager.dto.reponse;

import java.time.LocalDateTime;

/**
 * @author Neto
 *
 */
public class Response<T> {

	private T data;
	private Object errors;

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the errors
	 */
	public Object getErrors() {
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(Object errors) {
		this.errors = errors;
	}

	/**
	 * 
	 * @param msgError
	 */
	public void addErrorToResponse(final String msgError) {
		ResponseError error = new ResponseError();
		error.setDetails(msgError);
		error.setLocalDateTime(LocalDateTime.now());
		setErrors(error);
	}

}
