/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blessing.test.controllers;

import com.blessing.test.entities.Agence;
import com.blessing.test.services.AgenceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Franck NOUMOU
 */
@RestController
//@CrossOrigin("*")
@RequestMapping("/agences")
public class AgenceController{
    @Autowired
    AgenceService agenceService;
    @GetMapping(value = "")
    public List<Agence> getList() {
        return agenceService.findAll();
    }
    
    
    @GetMapping(value = "/{id}")
    public Agence findOne(@PathVariable Integer id) {
        return agenceService.findById(id); //To change body of generated methods, choose Tools | Templates.
    }
    
    @PostMapping(value = "/create")
    public List<Agence> persist(@RequestBody Agence agence) {
        return agenceService.save(agence); //To change body of generated methods, choose Tools | Templates.
    }
      
    @PostMapping(value = "/update")
    public List<Agence> update( @RequestBody Agence agence) {
        return agenceService.update(agence); //To change body of generated methods, choose Tools | Templates.
    }
    
    @PostMapping(value = "/delete")
    
    public  List<Agence> delete(@RequestBody Agence agence){
        return agenceService.delete(agence); //To change body of generated methods, choose Tools | Templates.
    }
    
    @GetMapping(value = "/delete/{id}")
    public  List<Agence> deleteById(@PathVariable Integer id){
        return agenceService.deleteById(id); //To change body of generated methods, choose Tools | Templates.
    }
}
