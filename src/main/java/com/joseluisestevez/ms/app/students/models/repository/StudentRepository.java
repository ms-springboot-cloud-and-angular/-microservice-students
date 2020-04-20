package com.joseluisestevez.ms.app.students.models.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.joseluisestevez.ms.commons.students.models.entity.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

    @Query("SELECT a FROM Student a WHERE upper(a.name) LIKE upper(concat('%', ?1, '%')) or upper(a.lastname) LIKE upper(concat('%', ?1, '%'))")
    List<Student> findByNameOrLastname(String name);

    Iterable<Student> findAllByOrderByIdAsc();

    Page<Student> findAllByOrderByIdAsc(Pageable pageable);

}
