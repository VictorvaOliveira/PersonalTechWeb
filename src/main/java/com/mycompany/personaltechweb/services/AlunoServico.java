/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltechweb.services;

import com.mycompany.personaltechweb.entities.Aluno;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.SUPPORTS;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author john
 */
@Stateless(name = "ejb/AlunoServico")
@LocalBean
@ValidateOnExecution(type = ExecutableType.ALL)
public class AlunoServico extends ServicoUsuario<Aluno>{

    @Override
    public Aluno criar() {
        return new Aluno();
    }
    
    @Override
    public boolean existe(@NotNull Aluno usuario) {
        TypedQuery<Aluno> query
                = entityManager.createNamedQuery(Aluno.ALUNO_POR_CPF, classe);
        query.setParameter(1, usuario.getCpf());
        return !query.getResultList().isEmpty();
    }
    
    @TransactionAttribute(SUPPORTS)
    public Aluno consultarPorCPF(@CPF String cpf) {
        return super.consultarEntidade(new Object[] {cpf}, Aluno.ALUNO_POR_CPF);
    } 
    
}
