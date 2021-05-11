package com.example.restmicro;


import com.example.professor.Professor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DummyProfessorData {

    private List<Professor> professors = new ArrayList<Professor>();

    public  List<Professor>getProfessors(){
        return  professors;
    }

    private  void  dummyProf(){
        Professor professor1 = new Professor();
        professor1.setId(125);
        professor1.setTitel("Dr.Ing");
        professor1.setName("Majid");
        addProfessor(professor1);

        Professor professor2 = new Professor();
        professor2.setId(255);
        professor2.setTitel("Prof.Dr.Ing");
        professor2.setName("sasaki");
        addProfessor(professor2);
    }

    public DummyProfessorData(){

        dummyProf();
    }
    public  void addProfessor(Professor prof){
        professors.add(prof);
    }
}
