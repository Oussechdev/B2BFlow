package com.example.facturationservice.service;

import ch.qos.logback.core.net.server.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
@FeignClient(name = "CLIENT-SERVICE")
public interface ClientRestClient {
    @GetMapping(path = "/clients/{id}")
    Client getClientById(@PathVariable Long id);

    @GetMapping(path = "/clients")
    List<Client> getClients();
}