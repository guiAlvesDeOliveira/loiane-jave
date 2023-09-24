package com.guilherme.crudspring.dto.mapper;

import com.guilherme.crudspring.dto.CourseDTO;
import com.guilherme.crudspring.enums.Category;
import com.guilherme.crudspring.models.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    public CourseDTO toDTO(Course course){
        if (course == null){
            return null;
        }

        return new CourseDTO(course.getId(), course.getName(), course.getCategory().getValue());
    }

    public Course toEntity(CourseDTO courseDTO){
        if (courseDTO == null){
            return null;
        }

        Course course = new Course();
        if (courseDTO.id() != null){
            course.setId(courseDTO.id());
        }
        course.setName(courseDTO.name());
        course.setCategory(convertCategoryValue(courseDTO.category()));
        return course;
    }

    public Category convertCategoryValue(String value){
        if (value == null){
            return null;
        }
        return switch (value){
            case "BACK-END" -> Category.BACKEND;
            case "FRONT-END" -> Category.FRONTEND;
            default -> throw new IllegalArgumentException("Catehoria inválida: " + value);
        };
    }
}