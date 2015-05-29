/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Dente;

/**
 *
 * @author thyago
 */
@Stateless
public class DenteFacade extends AbstractFacade<Dente> {
    @PersistenceContext(unitName = "OdontoMixPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DenteFacade() {
        super(Dente.class);
    }
    
}
