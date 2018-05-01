/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Annonce;
import bean.Trajet;
import bean.Ville;
import controller.util.SearchUtil;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Zakaria_Boumergoud
 */
@Stateless
public class AnnonceFacade extends AbstractFacade<Annonce> {

    @EJB
    private TrajetFacade trajetFacade;

    @PersistenceContext(unitName = "test2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnnonceFacade() {
        super(Annonce.class);
    }

    public void save(Annonce annonce, List<Trajet> items) {
        annonce.setId(generateId("Annonce", "id"));
        create(annonce);
        for (Trajet item : items) {
            item.setAnnonce(annonce);
            trajetFacade.create(item);
        }
    }

    public List<Annonce> findByCriteria(Ville villeDepart, Ville villeFin, Date dateMin, Date dateMax) {
        String query = constructQuery(villeDepart, villeFin, dateMin, dateMax);
        return em.createQuery(query).getResultList();
    }

    private String constructQuery(Ville villeDepart, Ville villeFin, Date dateMin, Date dateMax) {
        String query = "SELECT a FROM Annonce a WHERE 1 = 1 AND ";
        if (villeDepart != null) {
            query += SearchUtil.addConstraint("a", "villeDepart.id", "=", villeDepart.getId());
        }
        if (villeFin != null) {
            query += SearchUtil.addConstraint("a", "villeArrive.id", "=", villeFin.getId());

        }
        query += SearchUtil.addConstraintMinMaxDate("a", "dateAnnonce", dateMin, dateMax);
        return query;
    }

}
