/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Zakaria_Boumergoud
 */
@Entity
public class TrajetReponse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Ville villeDebit;
    @ManyToOne
    private Ville vileFin;
    private double prix;
    private String etat;

    public Ville getVilleDebit() {
        return villeDebit;
    }

    public void setVilleDebit(Ville villeDebit) {
        this.villeDebit = villeDebit;
    }

    public Ville getVileFin() {
        return vileFin;
    }

    public void setVileFin(Ville vileFin) {
        this.vileFin = vileFin;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        if (!(object instanceof TrajetReponse)) {
            return false;
        }
        TrajetReponse other = (TrajetReponse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.TrajetReponce[ id=" + id + " ]";
    }

}
