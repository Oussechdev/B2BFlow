package org.example.produitservice.service;
import java.util.List;
import org.example.produitservice.model.Produit;

public interface ProduitService {
    List<Produit> findAll();
    Produit findById(Long id);
    Produit saveProduit(Produit produit);
    void deleteProduit(Long id);
}
