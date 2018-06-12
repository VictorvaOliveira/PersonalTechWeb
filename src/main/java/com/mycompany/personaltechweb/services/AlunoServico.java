/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltechweb.services;

import com.mycompany.personaltechweb.entities.Aluno;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;

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
    
}
