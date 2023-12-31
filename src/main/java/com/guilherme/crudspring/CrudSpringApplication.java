package com.guilherme.crudspring;

import com.guilherme.crudspring.enums.Category;
import com.guilherme.crudspring.enums.Status;
import com.guilherme.crudspring.models.Course;
import com.guilherme.crudspring.models.Lesson;
import com.guilherme.crudspring.repositories.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(CourseRepository courseRepository) {
        return args -> {
            Course c = new Course();
            c.setName("Angular com Spring");
            c.setCategory(Category.FRONTEND);
            Lesson l = new Lesson();
            l.setName("Introdução");
            l.setYoutubeUrl("youtube.com");
            l.setCourse(c);
            c.getLessons().add(l);

            courseRepository.deleteAll();
            courseRepository.save(c);
        };  
    }
}
