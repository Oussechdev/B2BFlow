package org.example.produitservice.repository;

import org.example.produitservice.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Produit, Long> {
}

