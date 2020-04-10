package com.joseluisestevez.ms.app.students;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({ "com.joseluisestevez.ms.commons.students.models.entity" })
public class MicroserviceStudentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceStudentsApplication.class, args);
    }

}
