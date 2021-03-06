package dev.webapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.webapi.entite.Bancaire;
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

	@GetMapping(path = "/{matricule}")
	public Collaborateur voirCollaborateur(@PathVariable String matricule) {
		return colRepo.findAll().stream().filter(col -> col.getMatricule().equals(matricule)).findFirst()
				.orElse(new Collaborateur());
	}

	@PutMapping(path = "/{matricule}")
	public void editerCollaborateur(@PathVariable String matricule, @RequestBody Collaborateur newCollaborateur) {
		Collaborateur oldCollaborateur = colRepo.findAll().stream().filter(col -> col.getMatricule().equals(matricule))
				.findFirst().orElse(null);
		if (oldCollaborateur == null) {
			colRepo.save(newCollaborateur);
		} else {
			oldCollaborateur.setNom(newCollaborateur.getNom());
			oldCollaborateur.setPrenom(newCollaborateur.getPrenom());
			oldCollaborateur.setDepartement(newCollaborateur.getDepartement());
			colRepo.save(oldCollaborateur);
		}
	}

	@GetMapping(path = "/{matricule}/banque")
	public Bancaire voirBanque(@PathVariable String matricule) {
		return colRepo.findAll().stream().filter(col -> col.getMatricule().equals(matricule))
				.map(Collaborateur::getBanque).findFirst().orElse(new Bancaire());
	}

	@PutMapping(path = "/{matricule}/banque")
	public void editerBanque(@PathVariable String matricule, @RequestBody Bancaire newBanque) {
		Collaborateur collaborateur = colRepo.findAll().stream().filter(col -> col.getMatricule().equals(matricule))
				.findFirst().orElse(null);
		if (collaborateur == null) {
			return;
		} else {
			Bancaire oldBanque = collaborateur.getBanque();
			if (oldBanque == null) {
				collaborateur.setBanque(newBanque);
			} else {
				oldBanque.setLibelleBanque(newBanque.getLibelleBanque());
				oldBanque.setBic(newBanque.getBic());
				oldBanque.setIban(newBanque.getIban());
			}
			colRepo.save(collaborateur);
		}
	}

}
