/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Convenio;

/**
 *
 * @author thyago
 */
@Stateless
public class ConvenioFacade extends AbstractFacade<Convenio> {
    @PersistenceContext(unitName = "OdontoMixPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConvenioFacade() {
        super(Convenio.class);
    }
    
}
