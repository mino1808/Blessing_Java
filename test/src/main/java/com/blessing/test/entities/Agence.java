/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blessing.test.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Loader;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author Franck NOUMOU
 */
@Entity
@Table(name = "agence")
/*@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agence.findAll", query = "SELECT a FROM Agence a")
    , @NamedQuery(name = "Agence.findById", query = "SELECT a FROM Agence a WHERE a.id = :id")
    , @NamedQuery(name = "Agence.findByCode", query = "SELECT a FROM Agence a WHERE a.code = :code")
    , @NamedQuery(name = "Agence.findByNom", query = "SELECT a FROM Agence a WHERE a.nom = :nom")
    , @NamedQuery(name = "Agence.findByDescription", query = "SELECT a FROM Agence a WHERE a.description = :description")
    , @NamedQuery(name = "Agence.findByEtat", query = "SELECT a FROM Agence a WHERE a.etat = :etat")})
@SQLDelete(sql =
    "UPDATE action " +
    "SET etat = 0 " +
    "WHERE id = ?")
@Loader(namedQuery = "findAgenceById")
@NamedQuery(name = "findAgenceById", query =
    "SELECT a " +
    "FROM Agence a " +
    "WHERE " +
    "    a.id = ?1 AND " +
    "    a.etat = 1")
@Where(clause = "etat=1")*/
//@DynamicUpdate
public class Agence implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    

    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 245)
    @Column(name = "nom")
    private String nom;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 245)
    @Column(name = "localisation")
    private String localisation;

    public Agence(String nom, String localisation) {
        this.nom = nom;
        this.localisation = localisation;
    }

    public Agence() {
    }

    public Agence(Integer id, String nom, String localisation) {
        this.id = id;
        this.nom = nom;
        this.localisation = localisation;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
    
    
}
