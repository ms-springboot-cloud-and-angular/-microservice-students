package com.joseluisestevez.ms.app.students.services;

import java.util.List;

import com.joseluisestevez.ms.commons.services.CommonService;
import com.joseluisestevez.ms.commons.students.models.entity.Student;

public interface StudentService extends CommonService<Student> {

    List<Student> findByNameOrLastname(String name);

    Iterable<Student> findAllById(Iterable<Long> ids);

    void deleteCourseStudentById(Long id);

}
