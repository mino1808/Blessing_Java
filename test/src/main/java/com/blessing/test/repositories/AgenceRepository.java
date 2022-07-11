/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blessing.test.repositories;

import com.blessing.test.entities.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Franck NOUMOU
 */
@Repository
public interface AgenceRepository extends JpaRepository<Agence, Integer> {
    
}
