package com.joseluisestevez.ms.app.students.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joseluisestevez.ms.app.students.models.repository.StudentRepository;
import com.joseluisestevez.ms.commons.services.CommonServiceImpl;
import com.joseluisestevez.ms.commons.students.models.entity.Student;

@Service
public class StudentServiceImpl extends CommonServiceImpl<Student, StudentRepository> implements StudentService {

    @Transactional(readOnly = true)
    @Override
    public List<Student> findByNameOrLastname(String name) {
        return repository.findByNameOrLastname(name);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Student> findAllById(Iterable<Long> ids) {
        return repository.findAllById(ids);
    }

}
