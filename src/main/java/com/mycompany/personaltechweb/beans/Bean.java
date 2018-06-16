package com.mycompany.personaltechweb.beans;

import com.mycompany.personaltechweb.entities.Usuario;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class Bean<T extends Usuario> {

    protected T entidade;

    protected abstract boolean salvar(T entidade);

    @PostConstruct
    public void init() {
        iniciarCampos();
    }

    protected abstract void iniciarCampos();

    public T getEntidade() {
        return entidade;
    }

    public void setEntidade(T entidade) {
        this.entidade = entidade;
    }

    public void salvar() {
        try {
            boolean sucesso = salvar(entidade);
            if (sucesso) {
                adicionarMessagem(FacesMessage.SEVERITY_INFO, "Cadastro realizado com sucesso!");
            }
        } catch (Exception ex) {
            adicionarMessagem(FacesMessage.SEVERITY_WARN, ex.getMessage());
        } finally {
            iniciarCampos();
        }
    }

    protected void adicionarMessagem(FacesMessage.Severity severity, String mensagem) {
        FacesMessage message = new FacesMessage(severity, mensagem, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
