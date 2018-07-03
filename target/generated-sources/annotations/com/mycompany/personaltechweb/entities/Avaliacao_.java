package com.mycompany.personaltechweb.entities;

import com.mycompany.personaltechweb.entities.Aluno;
import com.mycompany.personaltechweb.entities.RespostasAvaliacao;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-07-02T20:41:24")
@StaticMetamodel(Avaliacao.class)
public class Avaliacao_ { 

    public static volatile SingularAttribute<Avaliacao, Aluno> aluno;
    public static volatile SingularAttribute<Avaliacao, Date> dataAvaliacao;
    public static volatile SingularAttribute<Avaliacao, String> nome_personal;
    public static volatile SingularAttribute<Avaliacao, Long> id;
    public static volatile ListAttribute<Avaliacao, RespostasAvaliacao> respostas;

}