package dev.webapi.entite;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Collaborateur extends Entite {
	
	private String matricule;
	private String nom;
	private String prenom;
	@ManyToOne
	private Departement departement;
	
	
	/**
	 * Getter for the matricule
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}
	/**
	 * Setter for the matricule
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	/**
	 * Getter for the nom
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * Setter for the nom
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * Getter for the prenom
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * Setter for the prenom
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * Getter for the departement
	 * @return the departement
	 */
	public Departement getDepartement() {
		return departement;
	}
	/**
	 * Setter for the departement
	 * @param departement the departement to set
	 */
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

}
