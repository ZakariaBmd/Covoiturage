/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Zakaria_Boumergoud
 */
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String prenom;
    private String nom;
    @OneToMany(mappedBy = "user")
    private List<Annonce> annonces;
    @OneToMany(mappedBy = "user")
    private List<ReponseAnnonce> reponseAnnonces;

    public List<Annonce> getAnnonces() {
        if (annonces == null)
            annonces = new ArrayList<Annonce>();
        return annonces;
    }

    public void setAnnonces(List<Annonce> annonces) {
        this.annonces = annonces;
    }

    public List<ReponseAnnonce> getReponseAnnonces() {
        if (reponseAnnonces == null)
            reponseAnnonces = new ArrayList<ReponseAnnonce>();
        return reponseAnnonces;
    }

    public void setReponceAnnonces(List<ReponseAnnonce> reponceAnnonces) {
        this.reponseAnnonces = reponceAnnonces;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public User() {
    }

    public User(String prenom, String nom, String email) {
        this.prenom = prenom;
        this.nom = nom;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", prenom=" + prenom + ", nom=" + nom + "}";
    }

}
