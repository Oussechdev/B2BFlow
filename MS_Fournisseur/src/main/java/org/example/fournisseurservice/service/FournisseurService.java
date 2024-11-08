package org.example.fournisseurservice.service;

import org.example.fournisseurservice.model.Fournisseur;
import org.example.fournisseurservice.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // Ajout de l'annotation @Service pour indiquer que c'est un service
public class FournisseurService {
    private final FournisseurRepository fournisseurRepository;

    @Autowired
    public FournisseurService(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    // Ajouter un fournisseur
    public Fournisseur addFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur); // Utilise save() pour ajouter le fournisseur à la base de données
    }

    // Obtenir tous les fournisseurs
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurRepository.findAll(); // Récupère tous les fournisseurs
    }

    // Obtenir un fournisseur par ID
    public Fournisseur getFournisseurById(Long id) { // Utilisez Long ici aussi
        return fournisseurRepository.findById(id).orElse(null); // Cherche le fournisseur par ID
    }
}
