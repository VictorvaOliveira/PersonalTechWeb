package com.mycompany.personaltechweb.entities;

import com.mycompany.personaltechweb.entities.Avaliacao;
import com.mycompany.personaltechweb.entities.Exercicio;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-06-10T15:39:54")
@StaticMetamodel(Aluno.class)
public class Aluno_ extends Usuario_ {

    public static volatile ListAttribute<Aluno, Exercicio> exercicios;
    public static volatile ListAttribute<Aluno, Avaliacao> avaliacoes;
    public static volatile CollectionAttribute<Aluno, String> telefones;

}