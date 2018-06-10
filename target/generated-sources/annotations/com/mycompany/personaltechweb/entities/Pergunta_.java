package com.mycompany.personaltechweb.entities;

import com.mycompany.personaltechweb.entities.RespostasAvaliacao;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-06-10T15:39:54")
@StaticMetamodel(Pergunta.class)
public class Pergunta_ { 

    public static volatile SingularAttribute<Pergunta, String> pergunta;
    public static volatile SingularAttribute<Pergunta, Long> id;
    public static volatile ListAttribute<Pergunta, RespostasAvaliacao> respostas;

}