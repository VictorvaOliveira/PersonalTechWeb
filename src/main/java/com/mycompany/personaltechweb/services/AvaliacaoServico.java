package com.mycompany.personaltechweb.services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.mycompany.personaltechweb.entities.Aluno;
import com.mycompany.personaltechweb.entities.Avaliacao;
import com.mycompany.personaltechweb.entities.Usuario;
import com.mycompany.personaltechweb.services.ServicoUsuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.SUPPORTS;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author michel
 */
@Stateless(name = "ejb/AvaliacaoServico")
@LocalBean
@ValidateOnExecution(type = ExecutableType.ALL)
public class AvaliacaoServico extends ServicoAvaliacao<Avaliacao>{

    @Override
    public Avaliacao criar() {
        return new Avaliacao();
    }
    
    @Override
    public boolean existe(@NotNull Avaliacao avaliacao) {
        TypedQuery<Avaliacao> query
                = entityManager.createNamedQuery(Avaliacao.AVALIACAO, classe);
        query.setParameter(1, avaliacao.getNome_personal());
        return !query.getResultList().isEmpty();
    }
    
    
    
    
    
}
