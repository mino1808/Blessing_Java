/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blessing.test.services;

import com.blessing.test.entities.Client;
import com.blessing.test.entities.Recharge;
import com.blessing.test.repositories.ClientRepository;
import com.blessing.test.repositories.RechargeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Franck NOUMOU
 */
@Service
public class RechargeService {
 
    @Autowired
    RechargeRepository rechargeRepository; 
    @Autowired
    ClientService clientService; 

   
    public List<Recharge> findAll() {
        return rechargeRepository.findAll();
    }
    
    public Recharge findById(Integer id) {
        return rechargeRepository.findById(id).orElse(null);
    }
    
    
    public List<Recharge> findByIdClient(Integer idClient) {
        return rechargeRepository.findByIdClientId(idClient);
    }

    public Recharge findById(int id) {
        return rechargeRepository.findById(id).orElse(null);
    }

    public List<Recharge> save(Recharge recharge) {
        System.out.println(recharge.getIdClient());
        Client client = new Client();
        client = clientService.findById(recharge.getIdClient().getId());        
        System.out.println("client" + client.toString());
        System.out.println("client" + client.getPrenom());
        client.setSolde(client.getSolde()+ recharge.getMontant());
        recharge.setIdClient(client);
        clientService.update(client);
        rechargeRepository.save(recharge);
        return rechargeRepository.findAll();
    }

    public List<Recharge> update(Recharge recharge) {
        save(recharge);
        return rechargeRepository.findAll();
    }

    public List<Recharge> deleteById(Integer id) {
        Recharge recharge = findById(id);
        return delete(recharge);
    }

    public List<Recharge> delete(Recharge recharge) {
        rechargeRepository.delete(recharge);
        return rechargeRepository.findAll();
    } 
}

