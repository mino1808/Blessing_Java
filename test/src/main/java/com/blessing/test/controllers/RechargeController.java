/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blessing.test.controllers;

import com.blessing.test.entities.Recharge;
import com.blessing.test.services.RechargeService;
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
@RequestMapping("/recharges")
public class RechargeController {
   @Autowired
    RechargeService rechargeService;
   
    @GetMapping(value = "")
    public List<Recharge> getList() {
        return rechargeService.findAll();
    }
    
    
    @GetMapping(value = "/{id}")
    public Recharge findOne(@PathVariable Integer id) {
        return rechargeService.findById(id); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @GetMapping(value = "/findByIdClient/{idClient}")
    public List<Recharge> findByIdClient(@PathVariable Integer idClient) {
        return rechargeService.findByIdClient(idClient); //To change body of generated methods, choose Tools | Templates.
    }
    
    @PostMapping(value = "/create")
    public List<Recharge> persist(@RequestBody Recharge recharge) {
        return rechargeService.save(recharge); //To change body of generated methods, choose Tools | Templates.
    }
      
    @PostMapping(value = "/update")
    public List<Recharge> update( @RequestBody Recharge recharge) {
        return rechargeService.update(recharge); //To change body of generated methods, choose Tools | Templates.
    }
    
    @PostMapping(value = "/delete")
    
    public  List<Recharge> delete(@RequestBody Recharge recharge){
        return rechargeService.delete(recharge); //To change body of generated methods, choose Tools | Templates.
    }
    
    @GetMapping(value = "/delete/{id}")
    public  List<Recharge> deleteById(@PathVariable Integer id){
        return rechargeService.deleteById(id); //To change body of generated methods, choose Tools | Templates.
    }
    
}
