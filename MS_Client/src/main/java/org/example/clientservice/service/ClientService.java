package org.example.clientservice.service;

import org.example.clientservice.model.Client;
import org.example.clientservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Ajouter un client
    public Client addClient(Client client) {
        return clientRepository.save(client); // Utilise save() pour ajouter le client à la base de données
    }

    // Obtenir tous les clients
    public List<Client> getAllClients() {
        return clientRepository.findAll(); // Récupère tous les clients
    }

    // Obtenir un client par ID
    public Client getClientById(int id) {
        return clientRepository.findById((long) id).orElse(null); // Cherche le client par ID
    }
}
