package dev.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.webapi.entite.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {

}
