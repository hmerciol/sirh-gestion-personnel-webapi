package dev.webapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.webapi.entite.Collaborateur;
import dev.webapi.entite.Departement;
import dev.webapi.repository.CollaborateurRepository;
import dev.webapi.repository.DepartementRepository;

@RestController
@RequestMapping("/api/collaborateurs")
public class CollaborateurController {

	@Autowired
	private CollaborateurRepository colRepo;
	@Autowired
	private DepartementRepository depRepo;

	@GetMapping
	public List<Collaborateur> listerCollaborateurs(
			@RequestParam(value = "departement", required = false) Integer depId) {
		if (depId != null) {
			Departement dep = depRepo.findOne(depId);
			return colRepo.findAll().stream().filter(col -> col.getDepartement().getId().equals(dep.getId()))
					.collect(Collectors.toList());
		}
		return colRepo.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/{matricule}")
	public Collaborateur voirCollaborateur(@PathVariable String matricule) {
		return colRepo.findAll().stream().filter(col -> col.getMatricule().equals(matricule)).findFirst().orElse(new Collaborateur());
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="/{matricule}")
	public void editerCollaborateur(@PathVariable String matricule, @RequestBody Collaborateur newCollaborateur) {
		Collaborateur oldCollaborateur = colRepo.findAll().stream().filter(col -> col.getMatricule().equals(matricule)).findFirst().orElse(null);
		if(oldCollaborateur == null) {
			colRepo.save(newCollaborateur);
		} else {
			oldCollaborateur.setNom(newCollaborateur.getNom());
			oldCollaborateur.setPrenom(newCollaborateur.getPrenom());
			oldCollaborateur.setDepartement(newCollaborateur.getDepartement());
			colRepo.save(oldCollaborateur);
		}
	}

}
