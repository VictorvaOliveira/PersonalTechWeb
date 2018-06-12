/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personaltechweb;

import com.mycompany.personaltechweb.services.AlunoServico;
import javax.naming.NamingException;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author john
 */
public class AlunoTest extends Teste {
    private AlunoServico AlunoServico;
    
     @Before
    public void setUp() throws NamingException {
        AlunoServico = (AlunoServico) container.getContext().lookup("java:global/classes/ejb/AlunoServico!com.mycompany.personaltechweb.services.AlunoServico");
    }
    
    @After
    public void tearDown() {
        AlunoServico = null;
    }
    
    @Test
    public void consultarItensPorCategoria() {
    }
}
