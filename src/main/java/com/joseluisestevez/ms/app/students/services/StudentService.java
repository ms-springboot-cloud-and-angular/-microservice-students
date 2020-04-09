package com.joseluisestevez.ms.app.students.services;

import java.util.Optional;

import com.joseluisestevez.ms.app.students.models.entity.Student;

public interface StudentService {

    Iterable<Student> findAll();

    Optional<Student> findById(Long id);

    Student save(Student student);

    void deleteById(Long id);
}
