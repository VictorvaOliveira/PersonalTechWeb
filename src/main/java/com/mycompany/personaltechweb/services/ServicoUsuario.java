/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltechweb.services;

import com.mycompany.personaltechweb.entities.Usuario;

import static javax.ejb.TransactionAttributeType.REQUIRED;
import static javax.ejb.TransactionAttributeType.SUPPORTS;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;
import static javax.ejb.TransactionManagementType.CONTAINER;
import static javax.persistence.PersistenceContextType.TRANSACTION;

import java.util.List;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 *
 * @author john
 * @param <T>
 */
@TransactionManagement(CONTAINER)
@TransactionAttribute(REQUIRED)
public abstract class ServicoUsuario<T extends Usuario> {

    @PersistenceContext(name = "PersonalTechWebPU", type = TRANSACTION)
    protected EntityManager entityManager;
    protected Class<T> classe;

    @TransactionAttribute(NOT_SUPPORTED)
    protected void setClasse(@NotNull Class<T> classe) {
        this.classe = classe;
    }

    @TransactionAttribute(SUPPORTS)
    public abstract T criar();

    @TransactionAttribute(SUPPORTS)
    public boolean existe(@NotNull T entidade) {
        return true;
    }

    public void persistir(@Valid T entidade) {
        if (existe(entidade)) {
            entityManager.persist(entidade);
        }
    }

    public void atualizar(@Valid T entidade) {
        if (existe(entidade)) {
            entityManager.merge(entidade);
            entityManager.flush();
        }
    }

    public void deletar(@Valid T entidade) {
        if (existe(entidade)) {
            T ems = entityManager.merge(entidade);
            entityManager.remove(ems);
            entityManager.flush();
        }

    }

    @TransactionAttribute(SUPPORTS)
    public T consultarPorId(@NotNull Long id) {
        return entityManager.find(classe, id);
    }

    @TransactionAttribute(SUPPORTS)
    protected T consultarEntidade(@NotNull Object[] parametros, String nomeQuery) {
        TypedQuery<T> query = entityManager.createNamedQuery(nomeQuery, classe);

        int i = 1;
        for (Object parametro : parametros) {
            query.setParameter(i++, parametro);
        }
        return query.getSingleResult();
    }

    @TransactionAttribute(SUPPORTS)
    protected List<T> consultarEntidades(Object[] parametros, String nomeQuery) {
        TypedQuery<T> query = entityManager.createNamedQuery(nomeQuery, classe);

        int i = 1;
        for (Object parametro : parametros) {
            query.setParameter(i++, parametro);
        }

        return query.getResultList();
    }

    @TransactionAttribute(SUPPORTS)
    protected List<T> getEntidades(String nomeQuery) {
        TypedQuery<T> query = entityManager.createNamedQuery(nomeQuery, classe);
        return query.getResultList();
    }
}
