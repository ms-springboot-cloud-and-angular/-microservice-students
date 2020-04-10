package com.joseluisestevez.ms.app.students.services;

import org.springframework.stereotype.Service;

import com.joseluisestevez.ms.app.students.models.entity.Student;
import com.joseluisestevez.ms.app.students.models.repository.StudentRepository;
import com.joseluisestevez.ms.commons.services.CommonServiceImpl;

@Service
public class StudentServiceImpl extends CommonServiceImpl<Student, StudentRepository> implements StudentService {

}
