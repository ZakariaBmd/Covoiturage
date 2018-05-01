/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Trajet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Zakaria_Boumergoud
 */
@Stateless
public class TrajetFacade extends AbstractFacade<Trajet> {

    @PersistenceContext(unitName = "test2PU")
    private EntityManager em;

    public Trajet clone(Trajet trajet) {
        Trajet myClone = new Trajet(trajet.getVilleDepart(), trajet.getVilleFin(), trajet.getPrix());
        return myClone;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrajetFacade() {
        super(Trajet.class);
    }

}
