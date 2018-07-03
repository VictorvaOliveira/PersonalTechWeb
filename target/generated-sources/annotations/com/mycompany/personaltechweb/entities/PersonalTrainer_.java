package com.mycompany.personaltechweb.entities;

import com.mycompany.personaltechweb.entities.Aluno;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-07-02T20:41:24")
@StaticMetamodel(PersonalTrainer.class)
public class PersonalTrainer_ extends Usuario_ {

    public static volatile ListAttribute<PersonalTrainer, Aluno> alunos;
    public static volatile CollectionAttribute<PersonalTrainer, String> telefones;

}