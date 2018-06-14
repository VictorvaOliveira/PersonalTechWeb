/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltechweb;

import static com.mycompany.personaltechweb.Teste.container;
import com.mycompany.personaltechweb.entities.Aluno;
import static com.mycompany.personaltechweb.entities.Aluno_.telefones;
import com.mycompany.personaltechweb.entities.Avaliacao;
import com.mycompany.personaltechweb.entities.Usuario;
import com.mycompany.personaltechweb.services.AlunoServico;
import com.mycompany.personaltechweb.services.AvaliacaoServico;
import java.util.Collection;
import javax.naming.NamingException;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author michel
 */
public class AvaliacaoTest extends Teste {
    private AvaliacaoServico AvaliacaoServico;
    
    
     @Before
    public void setUp() throws NamingException {
        AvaliacaoServico = (AvaliacaoServico) container.getContext().lookup("java:global/classes/ejb/AvaliacaoServico!com.mycompany.personaltechweb.services.AvaliacaoServico");
    }
    
    @After
    public void tearDown() {
        AvaliacaoServico = null;
    }
    
    @Test
    public void consultarItensPorCategoria() {
    }
    
    @Test
    public void existeAvaliacao() {
        Avaliacao avaliacao = AvaliacaoServico.criar();
        avaliacao.setNome_personal("THOR");
        assertTrue(AvaliacaoServico.existe(avaliacao));
    }
}
