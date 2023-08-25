package com.example.validation.service.mapper;

import com.example.validation.dto.LessonsDto;
import com.example.validation.model.Lessons;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class LessonsMapper {
    @Lazy
    @Autowired
    protected ModulesMapper modulesMapper;

    @Mapping(target = "courseId", ignore = true)
    @Mapping(target = "moduleId", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    public abstract Lessons toEntity(LessonsDto dto);

    //@Mapping(target = "updatedAt", ignore = true)
    //@Mapping(target = "deletedAt", ignore = true)
    //public abstract LessonsDto toDto(Lessons lessons);

    //@Mapping(target = "modules", expression = "java(this.modulesMapper.toDto(lessons.getModules()))")
    @Mapping(target = "modules", ignore = true)
    public abstract LessonsDto toDtoWithModules(Lessons lessons);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = Lessons.class)
    public abstract Lessons update(LessonsDto dto, @MappingTarget Lessons lessons);

    public void view(){
        Lessons lessons = new Lessons();
        LessonsDto lessonsDto = new LessonsDto();

        lessonsDto.setModules(this.modulesMapper.toDto(lessons.getModules()));
    }
}
