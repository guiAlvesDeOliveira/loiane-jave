package com.guilherme.crudspring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record CourseDTO(
        @JsonProperty("_id") Long id,
        @NotBlank @Length(min = 5, max = 100) @NotNull String name,
        @NotNull @Length(max = 20) @Pattern(regexp = "Back-end|Front-end") String category
        ) {


}
