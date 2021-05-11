package com.example.student;

import com.example.professor.Professor;
import com.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class StudentService extends HibernateUtil {
    private Transaction transaction = null;

        public Student createElement(Object obj) {

        Student student = (Student) obj;

        Session session = getSessionFactory().openSession();
        // start a transaction
        transaction = session.beginTransaction();
        // save the student objects
        session.save(student);
        // commit transaction
        transaction.commit();

        session.persist(student);
        session.flush();
        session.close();
        return student;
    }

    public Student updateElement(String id, Object obj) {

        Student student = null;
        Student updateProfessor = (Student) obj;

        Session session = getSessionFactory().openSession();
        // start a transaction
        transaction = session.beginTransaction();
        // save the student objects
        student = session.byId(Student.class).getReference(id);

        if(updateProfessor != null){
            student = updateProfessor;
        }
        session.update(student);
        // commit transaction
        transaction.commit();
        transaction.commit();
        session.persist(student);
        session.flush();
        session.close();
        System.out.println("the Prof is update  " + student.getName());
        return student;

    }

    public Student getElement(String imma) {

        Student student = null;
        Session session = getSessionFactory().openSession() ;
        // start a transaction
        transaction = session.beginTransaction();
        // save the student objects
        student = session.byId(Student.class).getReference(imma);
        // commit transaction
        transaction.commit();
        session.persist(student);
        session.flush();
        session.close();

        return student;
    }


    public Student deleteElement(String id) {

        // TODO Auto-generated method stub
        Student student = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        // start a transaction
        transaction = session.beginTransaction();
        // save the student objects
        student = session.byId(Student.class).getReference(id);

        session.delete(student);
        // commit transaction
        transaction.commit();

        session.persist(student);
        session.flush();
        session.close();
        return student;
    }

    public List<Student> getElements() {

        // TODO Auto-generated method stub
        List<Student> students = null;
        Session session = getSessionFactory().openSession();
        // start a transaction
        transaction = session.beginTransaction();
        // save the student objects
        students = session.createCriteria(Student.class).list();
        transaction.commit();
        session.persist(students);
        session.flush();
        session.close();
        return students;
    }


}
