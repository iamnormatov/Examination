package com.example.validation.dto;

import com.example.validation.model.Lessons;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModulesDto {
    private Integer moduleId;
    private Integer courseId;

    @NotBlank(message = "Name cannot be null or empty!")
    private String name;
    @NotBlank(message = "Description cannot be null or empty!")
    private String description;
    @NotBlank(message = "Lesson Hours cannot be null or empty!")
    private Integer lessonHours;
    @NotBlank(message = "Price cannot be null or empty!")
    private Integer price;

    private Set<LessonsDto> lessons;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
