package com.joseluisestevez.ms.app.students.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.joseluisestevez.ms.commons.students.models.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
