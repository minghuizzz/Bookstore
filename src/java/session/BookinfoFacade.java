/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Bookinfo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ZhuMinghu1
 */
@Stateless
public class BookinfoFacade extends AbstractFacade<Bookinfo> {
    @PersistenceContext(unitName = "BookstorePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookinfoFacade() {
        super(Bookinfo.class);
    }
    
}
