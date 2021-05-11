package com.example.professor;


import com.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class ProfessorService extends HibernateUtil {

    private   Transaction transaction = null;


    public Professor createElement(Object obj) {

        Professor professor = (Professor) obj;

        Session session = HibernateUtil.getSessionFactory().openSession();
            // start a transaction
        transaction = session.beginTransaction();
            // save the student objects
        session.save(professor);
            // commit transaction
        transaction.commit();
        return professor;
    }


    public Professor updateElement(int id, Object obj) {

        Professor professor = null;
        Professor updateProfessor = (Professor) obj;

        Session session = getSessionFactory().openSession();
            // start a transaction
        transaction = session.beginTransaction();
            // save the student objects
        professor = session.byId(Professor.class).getReference(id);

        if(updateProfessor != null){
            professor = updateProfessor;
        }
        session.update(professor);
            // commit transaction
        transaction.commit();

        System.out.println("the Prof is update  " + professor.getName());
        return professor;

    }


    public Professor getElement(int id) {

        Professor professor = null;
        Session session = getSessionFactory().openSession() ;
            // start a transaction
        transaction = session.beginTransaction();
            // save the student objects
        professor = session.byId(Professor.class).getReference(id);
            // commit transaction
        transaction.commit();

        return professor;
    }


    public Professor deleteElement(int id) {

        // TODO Auto-generated method stub
        Professor professor = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
            // start a transaction
        transaction = session.beginTransaction();
            // save the student objects
        professor = session.byId(Professor.class).getReference(id);

        session.delete(professor);
            // commit transaction
        transaction.commit();
        return professor;
    }


    public List<Professor> getElements() {

        // TODO Auto-generated method stub
        List<Professor> professor = null;
        Session session = getSessionFactory().openSession();
            // start a transaction
        transaction = session.beginTransaction();
            // save the student objects
        professor = session.createCriteria(Professor.class).list();
        transaction.commit();

        return professor;
    }


}
