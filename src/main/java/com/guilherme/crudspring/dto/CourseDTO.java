package com.guilherme.crudspring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.guilherme.crudspring.enums.Category;
import com.guilherme.crudspring.enums.validation.ValueOfEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record CourseDTO(
        @JsonProperty("_id") Long id,
        @NotBlank @Length(min = 5, max = 100) @NotNull String name,
        @NotNull @Length(max = 20) @ValueOfEnum(enumClass = Category.class) String category,
        @NotEmpty @NotNull @Valid List<LessonDTO> lessons
) {


}
