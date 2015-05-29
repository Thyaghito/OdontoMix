/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Anamnese;

/**
 *
 * @author thyago
 */
@Stateless
public class AnamneseFacade extends AbstractFacade<Anamnese> {
    @PersistenceContext(unitName = "OdontoMixPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnamneseFacade() {
        super(Anamnese.class);
    }
    
}
