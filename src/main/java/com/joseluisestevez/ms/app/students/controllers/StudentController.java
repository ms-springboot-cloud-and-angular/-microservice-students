package com.joseluisestevez.ms.app.students.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.joseluisestevez.ms.app.students.services.StudentService;
import com.joseluisestevez.ms.commons.controllers.CommonController;
import com.joseluisestevez.ms.commons.students.models.entity.Student;

@RestController
public class StudentController extends CommonController<Student, StudentService> {

    @GetMapping("/students-per-course")
    public ResponseEntity<?> getStudentsPerCourse(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(service.findAllById(ids));
    }

    @GetMapping("/uploads/photo/{id}")
    public ResponseEntity<?> viewPhoto(@PathVariable Long id) {
        Optional<Student> optional = service.findById(id);
        if (optional.isEmpty() || optional.get().getPhoto() == null) {
            return ResponseEntity.notFound().build();
        }

        Resource image = new ByteArrayResource(optional.get().getPhoto());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @Valid @RequestBody Student student, BindingResult result) {
        if (result.hasErrors()) {
            return this.validate(result);
        }
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

    @GetMapping("/filter/{name}")
    public ResponseEntity<?> filter(@PathVariable String name) {
        return ResponseEntity.ok(service.findByNameOrLastname(name));
    }

    @PostMapping("/create-with-photo")
    public ResponseEntity<?> createWithPhoto(@Valid Student student, BindingResult result, @RequestParam MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            student.setPhoto(file.getBytes());
        }
        return super.create(student, result);
    }

    @PutMapping("/edit-with-photo/{id}")
    public ResponseEntity<?> editWithPhoto(@PathVariable Long id, @Valid Student student, BindingResult result, @RequestParam MultipartFile file)
            throws IOException {
        if (result.hasErrors()) {
            return this.validate(result);
        }
        Optional<Student> optional = service.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Student currentStudent = optional.get();
        currentStudent.setEmail(student.getEmail());
        currentStudent.setName(student.getName());
        currentStudent.setLastname(student.getLastname());

        if (!file.isEmpty()) {
            currentStudent.setPhoto(file.getBytes());
        }

        Student studentSaved = service.save(currentStudent);

        return ResponseEntity.status(HttpStatus.CREATED).body(studentSaved);
    }

}
