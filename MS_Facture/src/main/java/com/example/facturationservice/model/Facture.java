package com.example.facturationservice.model;
import ch.qos.logback.core.net.server.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date dateFacture;

    @OneToMany(mappedBy = "facture")
    private Collection<ProduitArticle> listeProduits;

    private Long idClient;

    @Transient
    private Client client;

    public Facture(Object o, Date date, String string, Client client) {
    }
}
