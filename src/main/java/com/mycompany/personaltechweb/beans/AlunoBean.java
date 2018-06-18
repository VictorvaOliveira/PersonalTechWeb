package com.mycompany.personaltechweb.beans;

import com.mycompany.personaltechweb.entities.Aluno;
import com.mycompany.personaltechweb.services.AlunoServico;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("AlunoBean")
public class AlunoBean extends Bean<Aluno> implements Serializable {

    private AlunoServico alunoServico;

    @Override
    protected boolean salvar(Aluno entidade) {
        alunoServico.persistir(entidade);
        return true;
    }

    @Override
    protected void iniciarCampos() {
        setEntidade(alunoServico.criar());
    }

}
