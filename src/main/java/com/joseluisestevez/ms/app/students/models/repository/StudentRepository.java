package com.joseluisestevez.ms.app.students.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.joseluisestevez.ms.commons.students.models.entity.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

    @Query("SELECT a FROM Student a WHERE a.name LIKE %?1% or a.lastname LIKE %?1%")
    List<Student> findByNameOrLastname(String name);

}
