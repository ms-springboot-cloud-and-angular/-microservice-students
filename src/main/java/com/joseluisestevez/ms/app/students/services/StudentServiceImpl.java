package com.joseluisestevez.ms.app.students.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joseluisestevez.ms.app.students.clients.CourseFeingClient;
import com.joseluisestevez.ms.app.students.models.repository.StudentRepository;
import com.joseluisestevez.ms.commons.services.CommonServiceImpl;
import com.joseluisestevez.ms.commons.students.models.entity.Student;

@Service
public class StudentServiceImpl extends CommonServiceImpl<Student, StudentRepository> implements StudentService {

    @Autowired
    private CourseFeingClient courseFeingClient;

    @Transactional(readOnly = true)
    @Override
    public Iterable<Student> findAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Student> findAll(Pageable pageable) {
        return repository.findAllByOrderByIdAsc(pageable);
    }

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

    @Override
    public void deleteCourseStudentById(Long id) {
        courseFeingClient.deleteCourseStudentById(id);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
        this.deleteCourseStudentById(id);
    }

}
