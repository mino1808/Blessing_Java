/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blessing.test.controllers;

import com.blessing.test.entities.Client;
import com.blessing.test.services.ClientService;
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
@RequestMapping("/clients")
public class ClientController {
   @Autowired
    ClientService clientService;
   
    @GetMapping(value = "")
    public List<Client> getList() {
        return clientService.findAll();
    }
    
    
    @GetMapping(value = "/{id}")
    public Client findOne(@PathVariable Integer id) {
        return clientService.findById(id); //To change body of generated methods, choose Tools | Templates.
    }
    
    @PostMapping(value = "/create")
    public List<Client> persist(@RequestBody Client client) {
        return clientService.save(client); //To change body of generated methods, choose Tools | Templates.
    }
      
    @PostMapping(value = "/update")
    public List<Client> update( @RequestBody Client client) {
        return clientService.update(client); //To change body of generated methods, choose Tools | Templates.
    }
    
    @PostMapping(value = "/delete")
    
    public  List<Client> delete(@RequestBody Client client){
        return clientService.delete(client); //To change body of generated methods, choose Tools | Templates.
    }
    
    @GetMapping(value = "/delete/{id}")
    public  List<Client> deleteById(@PathVariable Integer id){
        return clientService.deleteById(id); //To change body of generated methods, choose Tools | Templates.
    }
    
}
