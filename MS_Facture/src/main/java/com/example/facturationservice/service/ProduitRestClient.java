package com.example.facturationservice.service;

import org.example.produitservice.model.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(name="PRODUIT-SERVICE")
public interface ProduitRestClient {
    @GetMapping(path = "/produits")
    PagedModel<Produit> pageProduit(@RequestParam(value = "page") int page,
                                    @RequestParam(value = "taille") int taille);

    @GetMapping(path = "/produits/{id}")
    Produit getProduitById(@PathVariable Long id);
}