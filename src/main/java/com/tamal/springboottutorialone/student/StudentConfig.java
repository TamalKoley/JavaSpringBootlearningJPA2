package com.tamal.springboottutorialone.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student s1 = new Student(
                    "Tamal",
                    "tamal@gmail.com",
                    LocalDate.of(1996, Month.JULY, 6)


            );

            Student s2 = new Student(
                    "Bubai",
                    "bubai@gmail.com",
                    LocalDate.of(1998, Month.FEBRUARY, 13)

            );
            studentRepository.saveAll(List.of(s1, s2));
        };

    }
}
