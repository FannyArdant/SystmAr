package com.example.restmicro;


import com.example.professor.Professor;
import com.example.student.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DummyStudentData {

    private List<Student> students = new ArrayList<Student>();

    public  List<Student>getStudents(){
        return  students;
    }

    private  void  dummyStudent(){
        Student student1 = new Student();
        student1.setImmatrikul("2899");
        student1.setName("NgoOnla");
        student1.setSemester(4);

        addStudent(student1);

        Student student2 = new Student();
        student2.setImmatrikul("2899");
        student2.setName("Clotide");
        student2.setSemester(4);
        addStudent(student2);

    }

    public DummyStudentData(){

        dummyStudent();
    }
    public  void addStudent(Student student){
        students.add(student);
    }
}
