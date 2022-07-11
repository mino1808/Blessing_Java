/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blessing.test.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Franck NOUMOU
 */
@Entity
@Table(name = "client")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 245)
    @Column(name = "nom")
    private String nom;
    
    @Basic(optional = true)
    @NotNull
    @Size(min = 1, max = 245)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sexe")
    private String sexe;
    @Basic(optional = false) 
    @NotNull
    private Double solde;
    @Basic(optional = false) 
    @NotNull
    private String password;
    @Basic(optional = false) 
    @NotNull
    private String email;    
    @Basic(optional = false) 
    @NotNull
    private String tel;

    public Client(Integer id) {
        this.id = id;
    }

    public Client() {
    }

    public Client(Integer id, String nom, String prenom, String sexe, Double solde, String password, String email, String tel) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.solde = solde;
        this.password = password;
        this.email = email;
        this.tel = tel;
    }
   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "com.blessing.entities.Client[ id=" + id + " ]";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
    
}
