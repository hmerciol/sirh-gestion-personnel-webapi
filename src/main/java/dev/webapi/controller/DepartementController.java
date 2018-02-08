package dev.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.webapi.entite.Departement;
import dev.webapi.repository.DepartementRepository;

@RestController
@RequestMapping("/api/departements")
public class DepartementController {
	
	@Autowired
	private DepartementRepository depRepo;
	
	@GetMapping
	public List<Departement> listerDepartements(){
		return depRepo.findAll();
	}

}
