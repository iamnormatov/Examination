package com.example.validation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LessonsDto {
    private Integer lessonsId;
    private Integer courseId;
    private Integer moduleId;
    private String username;
    private String password;

    @NotBlank(message = "Title cannot be null or empty!")
    private String title;
    @NotBlank(message = "Description cannot be null or empty!")
    private String description;
    private boolean status;

    private String content;
    private ModulesDto modules;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
