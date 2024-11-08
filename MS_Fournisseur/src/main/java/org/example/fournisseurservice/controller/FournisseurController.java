package org.example.fournisseurservice.controller;

import org.example.fournisseurservice.model.Fournisseur;
import org.example.fournisseurservice.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseurs") // C'est mieux de grouper les endpoints sous une racine
public class FournisseurController {
    private final FournisseurService fournisseurService;

    @Autowired
    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    // Endpoint pour ajouter un fournisseur
    @PostMapping("/add")
    public ResponseEntity<Fournisseur> addFournisseur(@RequestBody Fournisseur fournisseur) {
        Fournisseur savedFournisseur = fournisseurService.addFournisseur(fournisseur);
        return ResponseEntity.ok(savedFournisseur);
    }

    // Endpoint pour obtenir tous les fournisseurs
    @GetMapping("/all")
    public ResponseEntity<List<Fournisseur>> getAllFournisseurs() {
        List<Fournisseur> fournisseurs = fournisseurService.getAllFournisseurs();
        return ResponseEntity.ok(fournisseurs);
    }

    // Endpoint pour obtenir un fournisseur par ID
    @GetMapping("/{id}")
    public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable Long id) {  // Utilisez Long ici
        Fournisseur fournisseur = fournisseurService.getFournisseurById(id);
        return fournisseur != null ? ResponseEntity.ok(fournisseur) : ResponseEntity.notFound().build();
    }
}
