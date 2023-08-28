package com.example.validation.service.mapper;

import com.example.validation.dto.ModulesDto;
import com.example.validation.model.Modules;
import java.util.stream.Collectors;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-28T11:14:36+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class ModulesMapperImpl extends ModulesMapper {

    @Override
    public Modules toEntity(ModulesDto dto) {
        if ( dto == null ) {
            return null;
        }

        Modules.ModulesBuilder modules = Modules.builder();

        modules.moduleId( dto.getModuleId() );
        modules.name( dto.getName() );
        modules.description( dto.getDescription() );
        modules.lessonHours( dto.getLessonHours() );
        modules.price( dto.getPrice() );
        modules.createdAt( dto.getCreatedAt() );

        return modules.build();
    }

    @Override
    public ModulesDto toDto(Modules modules) {
        if ( modules == null ) {
            return null;
        }

        ModulesDto.ModulesDtoBuilder modulesDto = ModulesDto.builder();

        modulesDto.moduleId( modules.getModuleId() );
        modulesDto.courseId( modules.getCourseId() );
        modulesDto.name( modules.getName() );
        modulesDto.description( modules.getDescription() );
        modulesDto.lessonHours( modules.getLessonHours() );
        modulesDto.price( modules.getPrice() );
        modulesDto.createdAt( modules.getCreatedAt() );

        return modulesDto.build();
    }

    @Override
    public Modules update(ModulesDto dto, Modules modules) {
        if ( dto == null ) {
            return modules;
        }

        if ( dto.getModuleId() != null ) {
            modules.setModuleId( dto.getModuleId() );
        }
        if ( dto.getCourseId() != null ) {
            modules.setCourseId( dto.getCourseId() );
        }
        if ( dto.getName() != null ) {
            modules.setName( dto.getName() );
        }
        if ( dto.getDescription() != null ) {
            modules.setDescription( dto.getDescription() );
        }
        if ( dto.getLessonHours() != null ) {
            modules.setLessonHours( dto.getLessonHours() );
        }
        if ( dto.getPrice() != null ) {
            modules.setPrice( dto.getPrice() );
        }
        if ( dto.getUpdatedAt() != null ) {
            modules.setUpdatedAt( dto.getUpdatedAt() );
        }

        return modules;
    }
}
