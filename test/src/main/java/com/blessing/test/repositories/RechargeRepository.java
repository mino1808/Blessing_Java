/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blessing.test.repositories;

import com.blessing.test.entities.Recharge;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Franck NOUMOU
 */
@Repository
public interface RechargeRepository extends JpaRepository<Recharge, Integer> {
    List<Recharge> findByIdClientId(Integer idClient); 
}
