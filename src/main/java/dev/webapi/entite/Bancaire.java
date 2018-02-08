package dev.webapi.entite;

import javax.persistence.Embeddable;

@Embeddable
public class Bancaire {
	
	private String libelleBanque;
	private String bic;
	private String iban;
	
	/**
	 * Getter for the libelleBanque
	 * @return the libelleBanque
	 */
	public String getLibelleBanque() {
		return libelleBanque;
	}
	/**
	 * Setter for the libelleBanque
	 * @param libelleBanque the libelleBanque to set
	 */
	public void setLibelleBanque(String libelleBanque) {
		this.libelleBanque = libelleBanque;
	}
	/**
	 * Getter for the bic
	 * @return the bic
	 */
	public String getBic() {
		return bic;
	}
	/**
	 * Setter for the bic
	 * @param bic the bic to set
	 */
	public void setBic(String bic) {
		this.bic = bic;
	}
	/**
	 * Getter for the iban
	 * @return the iban
	 */
	public String getIban() {
		return iban;
	}
	/**
	 * Setter for the iban
	 * @param iban the iban to set
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}

}
