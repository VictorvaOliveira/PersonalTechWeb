/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltechweb.services;

import com.mycompany.personaltechweb.entities.PersonalTrainer;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;

/**
 *
 * @author victor
 */
@Stateless(name="ejb/PersonalTrainerServico")
@LocalBean
@ValidateOnExecution(type = ExecutableType.ALL)
public class PersonalTrainerServico extends ServicoUsuario<PersonalTrainer> {

    
    @Override
    public PersonalTrainer criar() {
        return new PersonalTrainer(); 
    }
        
    /**
     * Método para realizar a contagem de Personais cadastrados
     * @return 
     */
    public List<PersonalTrainer> quantidadePersonalTrainer(){
        return super.consultarEntidades(new Object[] {}, PersonalTrainer.QUANTIDADE_PERSONAL_TRAINER);
    }
    /**
     * Método para realizar a consulta de somente um personal trainer
     * @param id
     * @return 
     */
    public PersonalTrainer consultaPorID(long id){
        return super.consultarEntidade(new Object[] {id}, PersonalTrainer.CONSULTAR_POR_ID);
    }

    public Object removerPersonalPorID(long id) {
        return super.consultarEntidade(new Object[] {id}, PersonalTrainer.REMOVER_POR_ID);
    }
}
