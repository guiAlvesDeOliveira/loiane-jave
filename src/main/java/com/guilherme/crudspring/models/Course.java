package com.guilherme.crudspring.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@SQLDelete(sql = "UPDATE Course SET status = 'INACTIVE' WHERE id = ?")
@Where(clause = "status = 'ACTIVE'")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotBlank
    @Length(min= 5, max=100)
    @NotNull
    @Column(nullable = false, length = 100)
    private String name;

    @NotNull
    @Length(max = 20)
    @Pattern(regexp = "Back-end|Front-end")
    @Column(length = 20, nullable = false)
    private String category;

    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "ACTIVE|INACTIVE")
    @Column(length = 10, nullable = false)
    private String status = "ACTIVE";
}
