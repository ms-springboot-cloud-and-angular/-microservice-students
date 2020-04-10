package com.joseluisestevez.ms.app.students;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviceStudentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceStudentsApplication.class, args);
    }

}
