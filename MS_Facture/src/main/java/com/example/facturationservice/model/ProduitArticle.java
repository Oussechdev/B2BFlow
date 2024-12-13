package com.example.facturationservice.model;

import jakarta.persistence.*;
import lombok.Data;
import org.example.produitservice.model.Produit;


@Entity
@Data
public class ProduitArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private long reference;

    private int quantite;

    private double prix;

    @ManyToOne
    private Facture facture;

    @Transient
    private Produit produit;
}

