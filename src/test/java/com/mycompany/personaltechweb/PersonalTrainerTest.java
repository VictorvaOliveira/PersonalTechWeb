/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltechweb;

//import com.mycompany.personaltechweb.entities.Endereco;
//import com.mycompany.personaltechweb.entities.PersonalTrainer;
import com.mycompany.personaltechweb.services.PersonalTrainerServico;
//import java.util.Calendar;
import javax.naming.NamingException;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author victor
 */
public class PersonalTrainerTest extends Teste {

    private PersonalTrainerServico PersonalTrainerServico;

    @Before
    public void setUp() throws NamingException {
        PersonalTrainerServico = (PersonalTrainerServico) container.getContext().lookup("java:global/classes/ejb/PersonalTrainerServico!com.mycompany.personaltechweb.services.PersonalTrainerServico");
    }

    @After
    public void tearDown() {
        PersonalTrainerServico = null;
    }

    @Test
    public void quantidadePersonalTrainer() {
        assertEquals(6, PersonalTrainerServico.quantidadePersonalTrainer().size());
    }

    @Test
    public void consultaPorID() {
        assertNotNull(PersonalTrainerServico.consultaPorID(1));
    }

//    @Test
//    public void removerPersonalTrainer(){
//        assertNull(PersonalTrainerServico.removerPersonalPorID(13));
//    }
    
//    NÃO ESTÁ PERSISTINDO O PERSONAL TRAINER
//    CORRIGIR URGENTE
//    @Test
//    public void adicionarPersonalTrainer() {
//        PersonalTrainer pt = PersonalTrainerServico.criar();
//        pt.setNome("EJB");
//        pt.setSobrenome("DESCORP");
//        pt.setSexo("M");
//        pt.setLogin("javabeans");
//        pt.setSenha("EJB-123-ejb");
//        pt.setCpf("866.036.024-90");
//        
//        Calendar c = Calendar.getInstance();
//        c.set(Calendar.YEAR, 1990);
//        c.set(Calendar.MONTH, Calendar.JULY);
//        c.set(Calendar.DAY_OF_MONTH, 24);
//
//        pt.setDataNascimento(c.getTime());
//        pt.setEmail("ejb@descorp.com");
//        Endereco end = new Endereco();
//        end.setLogradouro("Miramar");
//        end.setBairro("Miro");
//        end.setNumero(765);
//        end.setCep("123123");
//        end.setCidade("Recife");
//        end.setEstado("PE");
//
//        pt.setEndereco(end);
//        
//        PersonalTrainerServico.persistir(pt);
//        assertNotNull(pt.getId());
//    }
}
