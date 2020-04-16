package com.joseluisestevez.ms.app.students.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-courses")
public interface CourseFeingClient {

    @DeleteMapping("/delete-student/{id}")
    void deleteCourseStudentById(@PathVariable Long id);

}
