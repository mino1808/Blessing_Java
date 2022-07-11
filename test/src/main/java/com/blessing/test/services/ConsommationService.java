/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blessing.test.services;

import com.blessing.test.entities.Client;
import com.blessing.test.entities.Consommation;
import com.blessing.test.repositories.ConsommationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Franck NOUMOU
 */
@Service
public class ConsommationService {
@Autowired
    ConsommationRepository consommationRepository; 
    @Autowired
    ClientService clientService; 

   
    public List<Consommation> findAll() {
        return consommationRepository.findAll();
    }
    
    public Consommation findById(Integer id) {
        return consommationRepository.findById(id).orElse(null);
    }
    
    
    public List<Consommation> findByIdClient(Integer idClient) {
        return consommationRepository.findByIdClientId(idClient);
    }

    public Consommation findById(int id) {
        return consommationRepository.findById(id).orElse(null);
    }

    public List<Consommation> save(Consommation consommation) {
        System.out.println(consommation.getIdClient());
        Client client = new Client();
        client = clientService.findById(consommation.getIdClient().getId());        
        System.out.println("client" + client.toString());
        System.out.println("client" + client.getPrenom());
        if(client.getSolde() >= consommation.getMontant()){
            client.setSolde(client.getSolde() - consommation.getMontant());
            consommation.setIdClient(client);
            clientService.update(client);
            consommationRepository.save(consommation);
        }
        return consommationRepository.findAll();
    }

    public List<Consommation> update(Consommation consommation) {
        save(consommation);
        return consommationRepository.findAll();
    }

    public List<Consommation> deleteById(Integer id) {
        Consommation consommation = findById(id);
        return delete(consommation);
    }

    public List<Consommation> delete(Consommation consommation) {
        consommationRepository.delete(consommation);
        return consommationRepository.findAll();
    } 
}

