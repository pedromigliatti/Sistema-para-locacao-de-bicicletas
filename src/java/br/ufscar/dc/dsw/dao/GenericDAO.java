/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

/**
 *
 * @author pedro
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDAO<T> {

    private final EntityManagerFactory emf;

    public GenericDAO() {
        emf = Persistence.createEntityManagerFactory("Sistema-para-locacao-de-bicicletasPU");
    }

    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
         
    abstract T get(Integer id);
     
    abstract List<T> getAll();
     
    abstract void save(T t);
     
    abstract void update(T t);
     
    abstract void delete(T t);
}