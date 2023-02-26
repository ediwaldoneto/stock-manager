/**
 * 
 */
package br.com.nt.stock.stockmanager.dto.reponse;

import java.time.LocalDateTime;

/**
 * @author Neto
 *
 */
public class ResponseError {

	private LocalDateTime localDateTime;
	private String details;

	/**
	 * @return the localDateTime
	 */
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	/**
	 * @param localDateTime the localDateTime to set
	 */
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

}
