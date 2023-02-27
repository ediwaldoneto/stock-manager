/**
 * 
 */
package br.com.nt.stock.stockmanager.exception;

/**
 * @author Neto
 *
 */
public class ProductNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5390468165991699033L;

	public ProductNotFoundException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ProductNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * @param message
	 */
	public ProductNotFoundException(String message) {
		super(message);

	}

}
