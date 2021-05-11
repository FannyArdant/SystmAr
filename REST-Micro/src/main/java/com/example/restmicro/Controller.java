package com.example.restmicro;


import com.example.professor.Professor;
import com.example.professor.ProfessorService;
import com.example.student.Student;
import com.example.student.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@SpringBootApplication
@RestController
public class Controller {


    private final ProfessorService professorService = new ProfessorService();

    private final StudentService studentService = new StudentService();

    public static void main(String[] args) {

        SpringApplication.run(Controller.class, args);


    }
    @GetMapping(path="/professors", produces = "application/json")
    public List<Professor> getProfessors()
    {
        return professorService.getElements();
       // return professorData.getProfessors();
    }

    @PostMapping(path= "/professor", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addNewProf(@RequestBody Professor professor)
    {
        professorService.createElement(professor);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(professor.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping(path="/professor/{Id}", produces = "application/json")
    public Professor getProfessor( @PathVariable int Id){
        return  professorService.getElement(Id);
    }

    @PutMapping("/professor/update/{id}")
    public Professor update(@PathVariable int id, @RequestBody Student update) {
        return  professorService.updateElement(id, update);
    }

    @DeleteMapping("professor/delete/{id}")
    public void delete(@PathVariable int id) {
        professorService.deleteElement(id);
    }


    @GetMapping(path="/students", produces = "application/json")
    public List<Student> getStudents()
    {
        return studentService.getElements();
        // return professorData.getProfessors();
    }


    @PostMapping(path= "/student", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Student> addNewStudent(@RequestBody Student student)
    {


        studentService.createElement(student);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(student.getImmatrikul())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping(path="/student/{imma}", produces = "application/json")
    public Student getStudent( @PathVariable String imma){

        return  studentService.getElement(imma);
    }

    @PutMapping("/student/update/{imma}")
    public Student updateStudent(@PathVariable String imma, @RequestBody Student update) {

        return  studentService.updateElement(imma, update);

    }

    @DeleteMapping("student/delete/{imma}")
    public void deleteStudent(@PathVariable String imma) {

        studentService.deleteElement(imma);
    }

}
