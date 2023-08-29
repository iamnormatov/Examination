package com.example.validation.service.mapper;

import com.example.validation.dto.LessonsDto;
import com.example.validation.model.Lessons;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class LessonsMapper {
    @Lazy
    @Autowired
    protected ModulesMapper modulesMapper;

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Mapping(target = "courseId", ignore = true)
    @Mapping(target = "moduleId", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @Mapping(target = "enabled", expression = "java(true)")
    @Mapping(target = "password", expression = "java(passwordEncoder.encode(dto.getPassword()))")
    public abstract Lessons toEntity(LessonsDto dto);

    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    public abstract LessonsDto toDto(Lessons lessons);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = Lessons.class)
    public abstract Lessons update(LessonsDto dto, @MappingTarget Lessons lessons);

}
