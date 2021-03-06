/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Cliente;
import br.ufscar.dc.dsw.pojo.Locadora;
import br.ufscar.dc.dsw.pojo.Papel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author pedro
 */
public class PapelDAO extends GenericDAO<Papel> {

    @Override
    Papel get(Integer id) {
        EntityManager em = this.getEntityManager();
        Papel papel = em.find(Papel.class, id);
        em.close();
        return papel;
    }

    @Override
    List<Papel> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createNamedQuery("Papel.findAll");
        List<Papel> listaPapeis = q.getResultList();
        em.close();

        return listaPapeis;
    }

    @Override
    public void save(Papel t) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(t);
        tx.commit();
        em.close();
    }

    @Override
    void update(Papel t) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(t);
        tx.commit();
        em.close();
    }

    @Override
    void delete(Papel t) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        t = em.getReference(Papel.class, t.getId());
        tx.begin();
        em.remove(t);
        tx.commit();
    }
    
}
