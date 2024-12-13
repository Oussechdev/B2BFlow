package org.example.produitservice;

import org.example.produitservice.model.Produit;
import org.example.produitservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProduitServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProduitServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository produitRepository) {
		return args -> {
			produitRepository.save(new Produit(null, "Ordinateur Portable", "Ordinateur portable avec 16 Go RAM", 15000));
			produitRepository.save(new Produit(null, "Smartphone", "Smartphone Android avec 128 Go de stockage", 6000));
			produitRepository.save(new Produit(null, "Tablette", "Tablette 10 pouces avec stylet", 8000));
			produitRepository.findAll().forEach(produit -> {
				System.out.println(produit.getNom());
			});
		};
	}
}
