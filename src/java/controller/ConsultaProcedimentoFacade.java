/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.ConsultaProcedimento;

/**
 *
 * @author thyago
 */
@Stateless
public class ConsultaProcedimentoFacade extends AbstractFacade<ConsultaProcedimento> {
    @PersistenceContext(unitName = "OdontoMixPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsultaProcedimentoFacade() {
        super(ConsultaProcedimento.class);
    }
    
}
