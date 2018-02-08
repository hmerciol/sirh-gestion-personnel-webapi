package dev.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.webapi.entite.Collaborateur;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {

}
