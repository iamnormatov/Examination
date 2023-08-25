package com.example.validation.service.mapper;

import com.example.validation.dto.ModulesDto;
import com.example.validation.model.Modules;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class ModulesMapper {

    @Autowired
    protected LessonsMapper lessonsMapper;

    @Mapping(target = "courseId", ignore = true)
    @Mapping(target = "lessons", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    public abstract Modules toEntity(ModulesDto dto);

    @Mapping(target = "lessons", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    public abstract ModulesDto toDto(Modules modules);

    @Mapping(target = "lessons", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = Modules.class)
    public abstract Modules update(ModulesDto dto, @MappingTarget Modules modules);

    @Mapping(target = "lessons", expression = "java(modules.getLessons().stream().map(this.lessonsMapper::toDto).collect(Collectors.toSet()))")
    public abstract ModulesDto toDtoWithLesson(Modules modules);

    public void view(){
        Modules modules = new Modules();
        ModulesDto modulesDto = new ModulesDto();

        modulesDto.setLessons(modules.getLessons().stream().map(this.lessonsMapper::toDto).collect(Collectors.toSet()));
    }
}
