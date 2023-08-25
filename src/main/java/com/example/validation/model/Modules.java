package com.example.validation.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "modules")
@NamedQueries(value = {
        @NamedQuery(name = "searchByNameTwo", query = "select m from Modules as m where m.name like concat(:val, '%') order by m.moduleId asc"),
})
public class Modules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer moduleId;
    private Integer courseId;
    private String name;
    private String description;
    private Integer lessonHours;
    private Integer price;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(insertable = false, updatable = false)
    private Courses courses;

    @OneToMany(mappedBy = "moduleId", fetch = FetchType.EAGER)
    private Set<Lessons> lessons;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
