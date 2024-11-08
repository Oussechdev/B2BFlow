package org.example.fournisseurservice.repository;

import org.example.fournisseurservice.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {  // Utilisez Long pour l'ID
}
