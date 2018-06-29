package com.mycompany.personaltechweb.beans;

import com.mycompany.personaltechweb.entities.Aluno;
import com.mycompany.personaltechweb.services.AlunoServico;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.inject.Inject;

@RequestScoped
@Named("AlunoBean")
public class AlunoBean extends Bean<Aluno> implements Serializable {

    @Inject
    private AlunoServico alunoServico;

    private List<Aluno> alunos;

    @Override
    protected boolean salvar(Aluno entidade) {
        alunoServico.persistir(entidade);
        return true;
    }

    @Override
    protected void iniciarCampos() {
        setEntidade(alunoServico.criar());
    }

    public List<Aluno> getAlunos() {
        if (alunos == null) {
            alunos = alunoServico.getAlunos();
        }
        return alunos;
    }

}
