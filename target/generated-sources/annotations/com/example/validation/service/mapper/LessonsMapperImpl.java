package com.example.validation.service.mapper;

import com.example.validation.dto.LessonsDto;
import com.example.validation.dto.ModulesDto;
import com.example.validation.model.Lessons;
import com.example.validation.model.Modules;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-28T11:14:35+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class LessonsMapperImpl extends LessonsMapper {

    @Override
    public Lessons toEntity(LessonsDto dto) {
        if ( dto == null ) {
            return null;
        }

        Lessons.LessonsBuilder lessons = Lessons.builder();

        lessons.lessonsId( dto.getLessonsId() );
        lessons.title( dto.getTitle() );
        lessons.description( dto.getDescription() );
        lessons.content( dto.getContent() );
        lessons.status( dto.isStatus() );
        lessons.modules( modulesDtoToModules( dto.getModules() ) );
        lessons.createdAt( dto.getCreatedAt() );

        return lessons.build();
    }

    @Override
    public LessonsDto toDto(Lessons lessons) {
        if ( lessons == null ) {
            return null;
        }

        LessonsDto.LessonsDtoBuilder lessonsDto = LessonsDto.builder();

        lessonsDto.lessonsId( lessons.getLessonsId() );
        lessonsDto.courseId( lessons.getCourseId() );
        lessonsDto.moduleId( lessons.getModuleId() );
        lessonsDto.title( lessons.getTitle() );
        lessonsDto.description( lessons.getDescription() );
        lessonsDto.status( lessons.isStatus() );
        lessonsDto.content( lessons.getContent() );
        lessonsDto.modules( modulesToModulesDto( lessons.getModules() ) );
        lessonsDto.createdAt( lessons.getCreatedAt() );

        return lessonsDto.build();
    }

    @Override
    public Lessons update(LessonsDto dto, Lessons lessons) {
        if ( dto == null ) {
            return lessons;
        }

        if ( dto.getLessonsId() != null ) {
            lessons.setLessonsId( dto.getLessonsId() );
        }
        if ( dto.getCourseId() != null ) {
            lessons.setCourseId( dto.getCourseId() );
        }
        if ( dto.getModuleId() != null ) {
            lessons.setModuleId( dto.getModuleId() );
        }
        if ( dto.getTitle() != null ) {
            lessons.setTitle( dto.getTitle() );
        }
        if ( dto.getDescription() != null ) {
            lessons.setDescription( dto.getDescription() );
        }
        if ( dto.getContent() != null ) {
            lessons.setContent( dto.getContent() );
        }
        lessons.setStatus( dto.isStatus() );
        if ( dto.getModules() != null ) {
            if ( lessons.getModules() == null ) {
                lessons.setModules( Modules.builder().build() );
            }
            modulesDtoToModules1( dto.getModules(), lessons.getModules() );
        }
        if ( dto.getUpdatedAt() != null ) {
            lessons.setUpdatedAt( dto.getUpdatedAt() );
        }

        return lessons;
    }

    protected Set<Lessons> lessonsDtoSetToLessonsSet(Set<LessonsDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Lessons> set1 = new LinkedHashSet<Lessons>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( LessonsDto lessonsDto : set ) {
            set1.add( toEntity( lessonsDto ) );
        }

        return set1;
    }

    protected Modules modulesDtoToModules(ModulesDto modulesDto) {
        if ( modulesDto == null ) {
            return null;
        }

        Modules.ModulesBuilder modules = Modules.builder();

        modules.moduleId( modulesDto.getModuleId() );
        modules.courseId( modulesDto.getCourseId() );
        modules.name( modulesDto.getName() );
        modules.description( modulesDto.getDescription() );
        modules.lessonHours( modulesDto.getLessonHours() );
        modules.price( modulesDto.getPrice() );
        modules.lessons( lessonsDtoSetToLessonsSet( modulesDto.getLessons() ) );
        modules.createdAt( modulesDto.getCreatedAt() );
        modules.updatedAt( modulesDto.getUpdatedAt() );
        modules.deletedAt( modulesDto.getDeletedAt() );

        return modules.build();
    }

    protected Set<LessonsDto> lessonsSetToLessonsDtoSet(Set<Lessons> set) {
        if ( set == null ) {
            return null;
        }

        Set<LessonsDto> set1 = new LinkedHashSet<LessonsDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Lessons lessons : set ) {
            set1.add( toDto( lessons ) );
        }

        return set1;
    }

    protected ModulesDto modulesToModulesDto(Modules modules) {
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
        modulesDto.lessons( lessonsSetToLessonsDtoSet( modules.getLessons() ) );
        modulesDto.createdAt( modules.getCreatedAt() );
        modulesDto.updatedAt( modules.getUpdatedAt() );
        modulesDto.deletedAt( modules.getDeletedAt() );

        return modulesDto.build();
    }

    protected void modulesDtoToModules1(ModulesDto modulesDto, Modules mappingTarget) {
        if ( modulesDto == null ) {
            return;
        }

        mappingTarget.setModuleId( modulesDto.getModuleId() );
        mappingTarget.setCourseId( modulesDto.getCourseId() );
        mappingTarget.setName( modulesDto.getName() );
        mappingTarget.setDescription( modulesDto.getDescription() );
        mappingTarget.setLessonHours( modulesDto.getLessonHours() );
        mappingTarget.setPrice( modulesDto.getPrice() );
        if ( mappingTarget.getLessons() != null ) {
            Set<Lessons> set = lessonsDtoSetToLessonsSet( modulesDto.getLessons() );
            if ( set != null ) {
                mappingTarget.getLessons().clear();
                mappingTarget.getLessons().addAll( set );
            }
            else {
                mappingTarget.setLessons( null );
            }
        }
        else {
            Set<Lessons> set = lessonsDtoSetToLessonsSet( modulesDto.getLessons() );
            if ( set != null ) {
                mappingTarget.setLessons( set );
            }
        }
        mappingTarget.setCreatedAt( modulesDto.getCreatedAt() );
        mappingTarget.setUpdatedAt( modulesDto.getUpdatedAt() );
        mappingTarget.setDeletedAt( modulesDto.getDeletedAt() );
    }
}
