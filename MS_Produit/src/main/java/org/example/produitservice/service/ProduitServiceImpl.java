package org.example.produitservice.service;

import org.example.produitservice.model.Produit;
import org.example.produitservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Produit> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Produit findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé !"));
    }

    @Override
    public Produit saveProduit(Produit produit) {
        return productRepository.save(produit);
    }

    @Override
    public void deleteProduit(Long id) {
        productRepository.deleteById(id);
    }
}
