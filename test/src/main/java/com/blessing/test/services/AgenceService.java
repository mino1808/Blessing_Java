/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blessing.test.services;

import com.blessing.test.entities.Agence;
import com.blessing.test.repositories.AgenceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Franck NOUMOU
 */
@Service
public class AgenceService {
    @Autowired
    AgenceRepository agenceRepository; 

   
    public List<Agence> findAll() {
        return agenceRepository.findAll();
    }
    
    public Agence findById(Integer id) {
        return agenceRepository.findById(id).orElse(null);
    }

    public Agence findById(int id) {
        return agenceRepository.findById(id).orElse(null);
    }

    public List<Agence> save(Agence agence) {

        agenceRepository.save(agence);
        return agenceRepository.findAll();
    }

    public List<Agence> update(Agence agence) {
        save(agence);
        return agenceRepository.findAll();
    }

    public List<Agence> deleteById(Integer id) {
        Agence agence = findById(id);
        return delete(agence);
    }

    public List<Agence> delete(Agence agence) {
        agenceRepository.delete(agence);
        return agenceRepository.findAll();
    } 
}
