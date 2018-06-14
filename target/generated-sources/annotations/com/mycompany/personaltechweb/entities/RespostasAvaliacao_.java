package com.mycompany.personaltechweb.entities;

import com.mycompany.personaltechweb.entities.Avaliacao;
import com.mycompany.personaltechweb.entities.Pergunta;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-06-13T15:01:58")
@StaticMetamodel(RespostasAvaliacao.class)
public class RespostasAvaliacao_ { 

    public static volatile SingularAttribute<RespostasAvaliacao, Pergunta> pergunta;
    public static volatile SingularAttribute<RespostasAvaliacao, String> txt_resposta;
    public static volatile SingularAttribute<RespostasAvaliacao, Long> id;
    public static volatile SingularAttribute<RespostasAvaliacao, Avaliacao> avaliacao;

}