package com.example.facturationservice.repository;

import com.example.facturationservice.model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FactureRepo extends JpaRepository<Facture, Long> {
}

