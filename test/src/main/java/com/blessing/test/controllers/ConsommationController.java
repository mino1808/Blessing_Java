/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blessing.test.controllers;

import com.blessing.test.entities.Consommation;
import com.blessing.test.services.ConsommationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Franck NOUMOU
 */
@RestController
@RequestMapping("/consommations")
public class ConsommationController {
   @Autowired
    ConsommationService consommationService;
   
    @GetMapping(value = "") 
    public List<Consommation> getList() {
        return consommationService.findAll();
    }
    
    
    @GetMapping(value = "/{id}")
    public Consommation findOne(@PathVariable Integer id) {
        return consommationService.findById(id); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @GetMapping(value = "/findByIdClient/{idClient}")
    public List<Consommation> findByIdClient(@PathVariable Integer idClient) {
        return consommationService.findByIdClient(idClient); //To change body of generated methods, choose Tools | Templates.
    }
    
    @PostMapping(value = "/create")
    public List<Consommation> persist(@RequestBody Consommation consommation) {
        return consommationService.save(consommation); //To change body of generated methods, choose Tools | Templates.
    }
      
    @PostMapping(value = "/update")
    public List<Consommation> update( @RequestBody Consommation consommation) {
        return consommationService.update(consommation); //To change body of generated methods, choose Tools | Templates.
    }
    
    @PostMapping(value = "/delete")
    
    public  List<Consommation> delete(@RequestBody Consommation consommation){
        return consommationService.delete(consommation); //To change body of generated methods, choose Tools | Templates.
    }
    
    @GetMapping(value = "/delete/{id}")
    public  List<Consommation> deleteById(@PathVariable Integer id){
        return consommationService.deleteById(id); //To change body of generated methods, choose Tools | Templates.
    }
    
}
