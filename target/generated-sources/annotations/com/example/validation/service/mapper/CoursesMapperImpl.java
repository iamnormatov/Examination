package com.example.validation.service.mapper;

import com.example.validation.dto.CoursesDto;
import com.example.validation.dto.LessonsDto;
import com.example.validation.dto.ModulesDto;
import com.example.validation.model.Courses;
import com.example.validation.model.Lessons;
import com.example.validation.model.Modules;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-28T11:14:36+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class CoursesMapperImpl extends CoursesMapper {

    @Override
    public Courses toEntity(CoursesDto dto) {
        if ( dto == null ) {
            return null;
        }

        Courses.CoursesBuilder courses = Courses.builder();

        courses.courseId( dto.getCourseId() );
        courses.type( dto.getType() );
        courses.name( dto.getName() );
        courses.description( dto.getDescription() );
        courses.perWeek( dto.getPerWeek() );
        courses.durationMonth( dto.getDurationMonth() );
        courses.durationDays( dto.getDurationDays() );
        courses.durationHours( dto.getDurationHours() );
        courses.intendedStudents( dto.getIntendedStudents() );
        courses.outcomes( dto.getOutcomes() );
        courses.benefits( dto.getBenefits() );
        courses.faq( dto.getFaq() );
        courses.status( dto.getStatus() );
        courses.lessons( lessonsDtoSetToLessonsSet( dto.getLessons() ) );
        courses.modules( modulesDtoSetToModulesSet( dto.getModules() ) );
        courses.createdAt( dto.getCreatedAt() );

        return courses.build();
    }

    @Override
    public CoursesDto toDto(Courses courses) {
        if ( courses == null ) {
            return null;
        }

        CoursesDto.CoursesDtoBuilder coursesDto = CoursesDto.builder();

        coursesDto.courseId( courses.getCourseId() );
        coursesDto.type( courses.getType() );
        coursesDto.name( courses.getName() );
        coursesDto.description( courses.getDescription() );
        coursesDto.perWeek( courses.getPerWeek() );
        coursesDto.durationMonth( courses.getDurationMonth() );
        coursesDto.durationDays( courses.getDurationDays() );
        coursesDto.durationHours( courses.getDurationHours() );
        coursesDto.intendedStudents( courses.getIntendedStudents() );
        coursesDto.outcomes( courses.getOutcomes() );
        coursesDto.benefits( courses.getBenefits() );
        coursesDto.faq( courses.getFaq() );
        coursesDto.status( courses.getStatus() );
        coursesDto.modules( modulesSetToModulesDtoSet( courses.getModules() ) );
        coursesDto.lessons( lessonsSetToLessonsDtoSet( courses.getLessons() ) );
        coursesDto.createdAt( courses.getCreatedAt() );

        return coursesDto.build();
    }

    @Override
    public Courses update(CoursesDto dto, Courses courses) {
        if ( dto == null ) {
            return courses;
        }

        if ( dto.getCourseId() != null ) {
            courses.setCourseId( dto.getCourseId() );
        }
        if ( dto.getType() != null ) {
            courses.setType( dto.getType() );
        }
        if ( dto.getName() != null ) {
            courses.setName( dto.getName() );
        }
        if ( dto.getDescription() != null ) {
            courses.setDescription( dto.getDescription() );
        }
        if ( dto.getPerWeek() != null ) {
            courses.setPerWeek( dto.getPerWeek() );
        }
        if ( dto.getDurationMonth() != null ) {
            courses.setDurationMonth( dto.getDurationMonth() );
        }
        if ( dto.getDurationDays() != null ) {
            courses.setDurationDays( dto.getDurationDays() );
        }
        if ( dto.getDurationHours() != null ) {
            courses.setDurationHours( dto.getDurationHours() );
        }
        if ( dto.getIntendedStudents() != null ) {
            courses.setIntendedStudents( dto.getIntendedStudents() );
        }
        if ( dto.getOutcomes() != null ) {
            courses.setOutcomes( dto.getOutcomes() );
        }
        if ( dto.getBenefits() != null ) {
            courses.setBenefits( dto.getBenefits() );
        }
        if ( dto.getFaq() != null ) {
            courses.setFaq( dto.getFaq() );
        }
        if ( dto.getStatus() != null ) {
            courses.setStatus( dto.getStatus() );
        }
        if ( courses.getLessons() != null ) {
            Set<Lessons> set = lessonsDtoSetToLessonsSet( dto.getLessons() );
            if ( set != null ) {
                courses.getLessons().clear();
                courses.getLessons().addAll( set );
            }
        }
        else {
            Set<Lessons> set = lessonsDtoSetToLessonsSet( dto.getLessons() );
            if ( set != null ) {
                courses.setLessons( set );
            }
        }
        if ( courses.getModules() != null ) {
            Set<Modules> set1 = modulesDtoSetToModulesSet( dto.getModules() );
            if ( set1 != null ) {
                courses.getModules().clear();
                courses.getModules().addAll( set1 );
            }
        }
        else {
            Set<Modules> set1 = modulesDtoSetToModulesSet( dto.getModules() );
            if ( set1 != null ) {
                courses.setModules( set1 );
            }
        }
        if ( dto.getUpdatedAt() != null ) {
            courses.setUpdatedAt( dto.getUpdatedAt() );
        }

        return courses;
    }

    protected Set<Lessons> lessonsDtoSetToLessonsSet(Set<LessonsDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Lessons> set1 = new LinkedHashSet<Lessons>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( LessonsDto lessonsDto : set ) {
            set1.add( lessonsDtoToLessons( lessonsDto ) );
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

    protected Lessons lessonsDtoToLessons(LessonsDto lessonsDto) {
        if ( lessonsDto == null ) {
            return null;
        }

        Lessons.LessonsBuilder lessons = Lessons.builder();

        lessons.lessonsId( lessonsDto.getLessonsId() );
        lessons.courseId( lessonsDto.getCourseId() );
        lessons.moduleId( lessonsDto.getModuleId() );
        lessons.title( lessonsDto.getTitle() );
        lessons.description( lessonsDto.getDescription() );
        lessons.content( lessonsDto.getContent() );
        lessons.status( lessonsDto.isStatus() );
        lessons.modules( modulesDtoToModules( lessonsDto.getModules() ) );
        lessons.createdAt( lessonsDto.getCreatedAt() );
        lessons.updatedAt( lessonsDto.getUpdatedAt() );
        lessons.deletedAt( lessonsDto.getDeletedAt() );

        return lessons.build();
    }

    protected Set<Modules> modulesDtoSetToModulesSet(Set<ModulesDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Modules> set1 = new LinkedHashSet<Modules>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ModulesDto modulesDto : set ) {
            set1.add( modulesDtoToModules( modulesDto ) );
        }

        return set1;
    }

    protected LessonsDto lessonsToLessonsDto(Lessons lessons) {
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
        lessonsDto.updatedAt( lessons.getUpdatedAt() );
        lessonsDto.deletedAt( lessons.getDeletedAt() );

        return lessonsDto.build();
    }

    protected Set<LessonsDto> lessonsSetToLessonsDtoSet(Set<Lessons> set) {
        if ( set == null ) {
            return null;
        }

        Set<LessonsDto> set1 = new LinkedHashSet<LessonsDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Lessons lessons : set ) {
            set1.add( lessonsToLessonsDto( lessons ) );
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

    protected Set<ModulesDto> modulesSetToModulesDtoSet(Set<Modules> set) {
        if ( set == null ) {
            return null;
        }

        Set<ModulesDto> set1 = new LinkedHashSet<ModulesDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Modules modules : set ) {
            set1.add( modulesToModulesDto( modules ) );
        }

        return set1;
    }
}
