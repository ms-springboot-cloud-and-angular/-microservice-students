package com.joseluisestevez.ms.app.students.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.joseluisestevez.ms.app.students.services.StudentService;
import com.joseluisestevez.ms.commons.controllers.CommonController;
import com.joseluisestevez.ms.commons.students.models.entity.Student;

@RestController
public class StudentController extends CommonController<Student, StudentService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> optional = service.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Student currentStudent = optional.get();
        currentStudent.setEmail(student.getEmail());
        currentStudent.setName(student.getName());
        currentStudent.setLastname(student.getLastname());

        Student studentSaved = service.save(currentStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentSaved);
    }

}
