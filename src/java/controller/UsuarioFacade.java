/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.Usuario;

/**
 *
 * @author thyago
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "OdontoMixPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    private EntityManager getPrivateEntityManager() {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("OdontoMixPU");
            return emf.createEntityManager();
        }
    
    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario findNamedQuery(String namedQuery, String param, String value) {       
        TypedQuery<Usuario> query = getPrivateEntityManager().createNamedQuery(namedQuery, Usuario.class);
        query.setParameter(param, value);         
        return query.getSingleResult();
    }
    
}
