/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltechweb;

import com.mycompany.personaltechweb.entities.Aluno;
import com.mycompany.personaltechweb.services.AlunoServico;
import javax.naming.NamingException;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author john
 */
public class AlunoTest extends Teste {

    private AlunoServico alunoServico;

    @Before
    public void setUp() throws NamingException {
        alunoServico = (AlunoServico) container.getContext().lookup("java:global/classes/ejb/AlunoServico!com.mycompany.personaltechweb.services.AlunoServico");
    }

    @After
    public void tearDown() {
        alunoServico = null;
    }

    @Test
    public void consultarItensPorCategoria() {
    }

    @Test
    public void existeAluno() {
        Aluno aluno = alunoServico.criar();

        aluno.setCpf("456.636.524-77");

        assertTrue(alunoServico.existe(aluno));

    }

    @Test
    public void getAlunoPorCPF() {
        assertNotNull(alunoServico.consultarPorCPF("456.636.524-77"));
    }
}
