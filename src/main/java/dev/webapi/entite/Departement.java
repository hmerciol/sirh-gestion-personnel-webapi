package dev.webapi.entite;

import javax.persistence.Entity;

@Entity
public class Departement extends Entite {
	
	private String libelle;

	/**
	 * Getter for the libelle
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Setter for the libelle
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
