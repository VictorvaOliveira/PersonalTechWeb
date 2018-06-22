/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltechweb.services;

import com.mycompany.personaltechweb.entities.Avaliacao;

import static javax.ejb.TransactionAttributeType.REQUIRED;
import static javax.ejb.TransactionAttributeType.SUPPORTS;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;
import static javax.ejb.TransactionManagementType.CONTAINER;
import static javax.persistence.PersistenceContextType.TRANSACTION;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;

/**
 *
 * @author michel
 */
@Stateless(name = "ejb/ServicoAvaliacao")
@LocalBean
@ValidateOnExecution(type = ExecutableType.ALL)
@TransactionManagement(CONTAINER)
@TransactionAttribute(REQUIRED)
public class ServicoAvaliacao<T extends Avaliacao> {

    @PersistenceContext(name = "avaliacao_ejb", type = TRANSACTION)
    protected EntityManager entityManager;
    protected Class<T> classe;

    protected void setClasse(@NotNull Class<T> classe) {
        this.classe = classe;
    }

    public Avaliacao criar() {
        return new Avaliacao();
    }

    @TransactionAttribute(SUPPORTS)
    public boolean existe(@NotNull T avaliacao) {
        TypedQuery<Avaliacao> query
                = (TypedQuery<Avaliacao>) entityManager.createNamedQuery(Avaliacao.AVALIACAO, classe);
        query.setParameter(1, avaliacao.getNome_personal());
        return !query.getResultList().isEmpty();
    }

    public void persistir(@Valid T entidade) {
        if (!existe(entidade)) {
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
    protected T consultarEntidade(Object[] parametros, String nomeQuery) {
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
}
