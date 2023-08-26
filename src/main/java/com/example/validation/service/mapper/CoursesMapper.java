package com.example.validation.service.mapper;

import com.example.validation.dto.CoursesDto;
import com.example.validation.model.Courses;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@Mapper(componentModel = "spring", imports = Collectors.class   )
public abstract class CoursesMapper {

    @Autowired
    protected ModulesMapper modulesMapper;
    @Autowired
    protected LessonsMapper lessonsMapper;

    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    public abstract Courses toEntity(CoursesDto dto);

    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    public abstract CoursesDto toDto(Courses courses);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = Courses.class)
    public abstract Courses update(CoursesDto dto, @MappingTarget Courses courses);

}
