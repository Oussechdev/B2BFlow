package com.example.facturationservice;

import com.example.facturationservice.model.Facture;
import com.example.facturationservice.model.ProduitArticle;
import com.example.facturationservice.repository.FactureRepo;
import com.example.facturationservice.repository.ProduitArticleRepo;
import com.example.facturationservice.service.ClientRestClient;
import com.example.facturationservice.service.ProduitRestClient;
import org.example.produitservice.model.Produit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.PagedModel;
import ch.qos.logback.core.net.server.Client;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@SpringBootApplication
public class FacturationServiceApplication implements CommandLineRunner {

    private final ClientRestClient clientRestClient;
    private final ProduitRestClient produitRestClient;
    private final FactureRepo factureRepo;
    private final ProduitArticleRepo produitArticleRepo;

    public FacturationServiceApplication(ClientRestClient clientRestClient, ProduitRestClient produitRestClient,
                                         FactureRepo factureRepo, ProduitArticleRepo produitArticleRepo) {
        this.clientRestClient = clientRestClient;
        this.produitRestClient = produitRestClient;
        this.factureRepo = factureRepo;
        this.produitArticleRepo = produitArticleRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(FacturationServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Fetch the client by ID (example ID: 11)
        var client = Optional.ofNullable(clientRestClient.getClientById(11L))
                .orElseThrow(() -> new RuntimeException("Client not found"));

        // Save a new facture with the client details
        Facture facture = factureRepo.save(new Facture(null, new Date(), client.toString(), client));

        // Fetch a list of products (example page size: 8, page number: 3)
        PagedModel<Produit> produitsPaged = produitRestClient.pageProduit(8, 3);
        List<Produit> produits = new ArrayList<>(produitsPaged.getContent());

        if (produits.isEmpty()) {
            System.err.println("No products found.");
            return;
        }

        produits.forEach(p -> {
            ProduitArticle produitArticle = new ProduitArticle();
            produitArticle.setReference(p.getId());
            produitArticle.setProduit(p);
            produitArticle.setQuantite(generateRandomQuantity(1, 20)); // Ensure quantite is between 1 and 20
            produitArticle.setFacture(facture);
            produitArticle.setPrix(produitArticle.getQuantite() * p.getPrix());
            produitArticleRepo.save(produitArticle);
        });

        System.out.println("Facture and ProduitArticles saved successfully.");
    }

    // Utility method to generate random quantities
    private int generateRandomQuantity(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
}
