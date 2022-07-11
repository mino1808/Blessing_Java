/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blessing.test.services;

import com.blessing.test.entities.Client;
import com.blessing.test.repositories.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Franck NOUMOU
 */
@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository; 

   
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
    
    public Client findById(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client findById(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    public List<Client> save(Client client) {

        clientRepository.save(client);
        return clientRepository.findAll();
    }

    public List<Client> update(Client client) {
        save(client);
        return clientRepository.findAll();
    }

    public List<Client> deleteById(Integer id) {
        Client client = findById(id);
        return delete(client);
    }

    public List<Client> delete(Client client) {
        clientRepository.delete(client);
        return clientRepository.findAll();
    } 
}
