package com.example.validation.service;

import com.example.validation.dto.LessonsDto;
import com.example.validation.dto.ResponseDto;
import com.example.validation.dto.SimpleCRUD;
import com.example.validation.model.Courses;
import com.example.validation.model.Lessons;
import com.example.validation.model.Modules;
import com.example.validation.repository.CoursesRepository;
import com.example.validation.repository.LessonsRepository;
import com.example.validation.repository.ModulesRepository;
import com.example.validation.service.mapper.LessonsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LessonsService implements SimpleCRUD<Integer, LessonsDto> {

    private final LessonsMapper lessonsMapper;
    private final LessonsRepository lessonsRepository;
    private final CoursesRepository coursesRepository;
    private final ModulesRepository modulesRepository;

    @Override
    public ResponseDto<LessonsDto> create(LessonsDto dto) {
        Optional<Courses> optional = this.coursesRepository.getCoursesById(dto.getCourseId());
        if (optional.isEmpty()){
            return ResponseDto.<LessonsDto>builder()
                    .code(-1)
                    .message("Courses are not found!")
                    .build();
        }
        Optional<Modules> optional1 = this.modulesRepository.getModulesById(dto.getModuleId());
        if (optional1.isEmpty()){
            return ResponseDto.<LessonsDto>builder()
                    .code(-1)
                    .message("Modules are not found!")
                    .build();
        }
        try {
            Lessons lessons = this.lessonsMapper.toEntity(dto);
            lessons.setCreatedAt(LocalDateTime.now());
            this.lessonsRepository.save(lessons);
            return ResponseDto.<LessonsDto>builder()
                    .success(true)
                    .message("OK")
                    .data(this.lessonsMapper.toDto(lessons))
                    .build();
        }catch (Exception e){
            return ResponseDto.<LessonsDto>builder()
                    .code(-2)
                    .message(String.format("Lessons while saving error %s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<LessonsDto> get(Integer entityId) {
        return this.lessonsRepository.getLessonsById(entityId)
                .map(courses -> ResponseDto.<LessonsDto>builder()
                        .success(true)
                        .message("OK")
                        .data(this.lessonsMapper.toDto(courses))
                        .build()
                )
                .orElse(ResponseDto.<LessonsDto>builder()
                        .code(-1)
                        .message("Lessons are not found!")
                        .build()
                );
    }

    @Override
    public ResponseDto<LessonsDto> update(LessonsDto dto, Integer entityId) {
        try {
            return this.lessonsRepository.getLessonsById(entityId)
                    .map(courses -> {
                        this.lessonsMapper.update(dto, courses);
                        courses.setUpdatedAt(LocalDateTime.now());
                        this.lessonsRepository.save(courses);
                        return ResponseDto.<LessonsDto>builder()
                                .success(true)
                                .message("OK")
                                .data(this.lessonsMapper.toDto(courses))
                                .build();
                    })
                    .orElse(ResponseDto.<LessonsDto>builder()
                            .code(-1)
                            .message("Lessons are not found!")
                            .build()
                    );
        }catch (Exception e){
            return ResponseDto.<LessonsDto>builder()
                    .code(-2)
                    .message(String.format("Lessons while update error %s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<LessonsDto> delete(Integer entityId) {
        try {
            return this.lessonsRepository.getLessonsById(entityId)
                    .map(courses -> {
                        courses.setDeletedAt(LocalDateTime.now());
                        this.lessonsRepository.save(courses);
                        return ResponseDto.<LessonsDto>builder()
                                .success(true)
                                .message("OK")
                                .data(this.lessonsMapper.toDto(courses))
                                .build();
                    })
                    .orElse(ResponseDto.<LessonsDto>builder()
                            .code(-1)
                            .message("Lessons are not found!")
                            .build()
                    );
        }catch (Exception e){
            return ResponseDto.<LessonsDto>builder()
                    .code(-2)
                    .message(String.format("Lessons while delete error %s", e.getMessage()))
                    .build();
        }
    }

    public ResponseDto<List<LessonsDto>> searchUserByName(String value) {
        List<Lessons> lessonsList = this.lessonsRepository.searchUserByName(value);
        if (lessonsList.isEmpty()) {
            return ResponseDto.<List<LessonsDto>>builder()
                    .code(-1)
                    .message("Lessons are not found")
                    .build();
        }
        return ResponseDto.<List<LessonsDto>>builder()
                .success(true)
                .message("OK")
                .data(lessonsList.stream().map(this.lessonsMapper::toDto).toList())
                .build();
    }
}
