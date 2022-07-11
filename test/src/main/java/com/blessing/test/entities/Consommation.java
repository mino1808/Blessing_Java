/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blessing.test.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Franck NOUMOU
 */
@Entity
public class Consommation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "montant")
    private Double montant;
        
    @Basic(optional = false)
    @NotNull
    @Column(name = "volume")
    private Double volume;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 245)
    @Column(name = "date_consommation")
    private Date dateConsommation;    
    
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Client idClient;

    public Consommation() {
    }

    public Consommation(Integer id, Double montant, Double volume, Date dateConsommation, Client idClient) {
        this.id = id;
        this.montant = montant;
        this.volume = volume;
        this.dateConsommation = dateConsommation;
        this.idClient = idClient;
    }
    
    
    public Consommation(Integer id, Double montant, Double volume, Date dateConsommation, Integer idClient) {
        this.id = id;
        this.montant = montant;
        this.volume = volume;
        this.dateConsommation = dateConsommation;
        this.idClient = new Client(idClient);
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
        if (!(object instanceof Consommation)) {
            return false;
        }
        Consommation other = (Consommation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.blessing.test.entities.Consommation[ id=" + id + " ]";
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Date getDateConsommation() {
        return dateConsommation;
    }

    public void setDateConsommation(Date dateConsommation) {
        this.dateConsommation = dateConsommation;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }
    
}
