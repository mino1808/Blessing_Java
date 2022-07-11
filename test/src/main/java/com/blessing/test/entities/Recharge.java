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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Franck NOUMOU
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Recharge.findByIdClient", query = "SELECT r FROM Recharge r WHERE r.idClient.id = :idClient")})
public class Recharge implements Serializable {

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
    @Size(min = 1, max = 50)
    @Column(name = "type")
    private String type;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_recharge")
    private Date dateRecharge;
    
    
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Client idClient;

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
        if (!(object instanceof Recharge)) {
            return false;
        }
        Recharge other = (Recharge) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.blessing.test.entities.Recharge[ id=" + id + " ]";
    }

    public Recharge() {
    }

    public Recharge(Integer id, Double montant, String type, Date dateRecharge, Integer idClient) {
        this.id = id;
        this.montant = montant;
        this.type = type;
        this.dateRecharge = dateRecharge;        
        this.idClient = new Client(idClient);
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateRecharge() {
        return dateRecharge;
    }

    public void setDateRecharge(Date dateRecharge) {
        this.dateRecharge = dateRecharge;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }
    
   
    
}
