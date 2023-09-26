package com.guilherme.crudspring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
        @NotNull @Length(max = 20) @Pattern(regexp = "BACK-END|FRONT-END") String category,
        @NotEmpty @NotNull @Valid List<LessonDTO> lessons
) {


}
