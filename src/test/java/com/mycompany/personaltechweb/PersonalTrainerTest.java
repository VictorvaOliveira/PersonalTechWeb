/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltechweb;

//import com.mycompany.personaltechweb.entities.Endereco;
//import com.mycompany.personaltechweb.entities.PersonalTrainer;
import com.mycompany.personaltechweb.entities.Endereco;
import com.mycompany.personaltechweb.entities.PersonalTrainer;
import com.mycompany.personaltechweb.services.PersonalTrainerServico;
import java.util.Calendar;
import javax.ejb.EJBException;
//import java.util.Calendar;
import javax.naming.NamingException;
import javax.validation.ConstraintViolationException;
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
    public void adicionarPersonalTrainer() {
        PersonalTrainer pt = PersonalTrainerServico.criar();
        pt.setNome("APROVA");
        pt.setSobrenome("DiBALA");
        pt.setSexo("M");
        pt.setLogin("bala666");
        pt.setSenha("aA1-personal");
        pt.setCpf("975.989.880-21");
        pt.setEmail("ejb@descorp.com");

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1990);
        c.set(Calendar.MONTH, Calendar.JULY);
        c.set(Calendar.DAY_OF_MONTH, 24);
        pt.setDataNascimento(c.getTime());

        Endereco end = new Endereco();
        end.setLogradouro("Miramar");
        end.setBairro("Miro");
        end.setNumero(765);
        end.setCep("123123");
        end.setCidade("Recife");
        end.setEstado("PE");
        pt.setEndereco(end);

        PersonalTrainerServico.persistir(pt);
        //assertTrue(PersonalTrainerServico.existe(pt)); // Testa apenas classe em si
        assertNotNull(pt.getId()); // Testa a Persistência
    }
    
    @Test
    public void consultaPorID() {
        PersonalTrainer pt = PersonalTrainerServico.consultaPorID((long) 1);
        assertEquals("cba123", pt.getLogin());
    }
   
    @Test
    public void quantidadePersonalTrainer() {
        assertEquals(7, PersonalTrainerServico.quantidadePersonalTrainer().size());
    }

    @Test
    public void removerPersonalTrainer() {
        PersonalTrainer pt = PersonalTrainerServico.consultaPorID((long)13);
        PersonalTrainerServico.deletar(pt);
        assertEquals(null, PersonalTrainerServico.consultaPorID((long)13));
    }

    @Test
    public void atualizarPersonalTrainer() {
        PersonalTrainer pt = PersonalTrainerServico.consultaPorID((long) 26);
        pt.setEmail("descorpejb@gmail.com");
        PersonalTrainerServico.atualizar(pt);
        assertEquals("descorpejb@gmail.com", pt.getEmail());
    }

    @Test
    public void atualizacaoInvalidaPersonalTrainer() {
        PersonalTrainer pt = PersonalTrainerServico.consultaPorID((long) 14);
        pt.setSenha("111111111");
        try {
            PersonalTrainerServico.atualizar(pt);
            assertTrue(false);
        } catch (EJBException ex) {
            assertTrue(ex.getCause() instanceof ConstraintViolationException);
        }
    }
}
