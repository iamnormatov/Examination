package com.example.validation.service;

import com.example.validation.dto.ModulesDto;
import com.example.validation.dto.ResponseDto;
import com.example.validation.dto.SimpleCRUD;
import com.example.validation.model.Courses;
import com.example.validation.model.Modules;
import com.example.validation.repository.CoursesRepository;
import com.example.validation.repository.ModulesRepository;
import com.example.validation.service.mapper.ModulesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModulesService implements SimpleCRUD<Integer, ModulesDto> {

    private final ModulesMapper modulesMapper;
    private final ModulesRepository modulesRepository;
    private final CoursesRepository coursesRepository;

    @Override
    public ResponseDto<ModulesDto> create(ModulesDto dto) {
        Optional<Courses> optional = this.coursesRepository.getCoursesById(dto.getCourseId());
        if (optional.isEmpty()){
            return ResponseDto.<ModulesDto>builder()
                    .code(-1)
                    .message("Courses are not found!")
                    .build();
        }
        try {
            Modules modules = this.modulesMapper.toEntity(dto);
            modules.setCreatedAt(LocalDateTime.now());
            this.modulesRepository.save(modules);
            return ResponseDto.<ModulesDto>builder()
                    .success(true)
                    .message("OK")
                    .data(this.modulesMapper.toDto(modules))
                    .build();
        }catch (Exception e){
            return ResponseDto.<ModulesDto>builder()
                    .code(-2)
                    .message(String.format("Modules while saving error %s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<ModulesDto> get(Integer entityId) {
        return this.modulesRepository.getModulesById(entityId)
                .map(courses -> ResponseDto.<ModulesDto>builder()
                        .success(true)
                        .message("OK")
                        .data(this.modulesMapper.toDto(courses))
                        .build()
                )
                .orElse(ResponseDto.<ModulesDto>builder()
                        .code(-1)
                        .message("Modules are not found!")
                        .build()
                );
    }

    @Override
    public ResponseDto<ModulesDto> update(ModulesDto dto, Integer entityId) {
        try {
            return this.modulesRepository.getModulesById(entityId)
                    .map(courses -> {
                        this.modulesMapper.update(dto, courses);
                        courses.setUpdatedAt(LocalDateTime.now());
                        this.modulesRepository.save(courses);
                        return ResponseDto.<ModulesDto>builder()
                                .success(true)
                                .message("OK")
                                .data(this.modulesMapper.toDto(courses))
                                .build();
                    })
                    .orElse(ResponseDto.<ModulesDto>builder()
                            .code(-1)
                            .message("Modules are not found!")
                            .build()
                    );
        }catch (Exception e){
            return ResponseDto.<ModulesDto>builder()
                    .code(-2)
                    .message(String.format("Modules while update error %s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<ModulesDto> delete(Integer entityId) {
        try {
            return this.modulesRepository.getModulesById(entityId)
                    .map(courses -> {
                        courses.setDeletedAt(LocalDateTime.now());
                        this.modulesRepository.save(courses);
                        return ResponseDto.<ModulesDto>builder()
                                .success(true)
                                .message("OK")
                                .data(this.modulesMapper.toDto(courses))
                                .build();
                    })
                    .orElse(ResponseDto.<ModulesDto>builder()
                            .code(-1)
                            .message("Modules are not found!")
                            .build()
                    );
        }catch (Exception e){
            return ResponseDto.<ModulesDto>builder()
                    .code(-2)
                    .message(String.format("Modules while delete error %s", e.getMessage()))
                    .build();
        }
    }

    public ResponseDto<List<ModulesDto>> searchUserByName(String value) {
        List<Modules> modulesList = this.modulesRepository.searchUserByName(value);
        if (modulesList.isEmpty()) {
            return ResponseDto.<List<ModulesDto>>builder()
                    .code(-1)
                    .message("Modules are not found")
                    .build();
        }
        return ResponseDto.<List<ModulesDto>>builder()
                .success(true)
                .message("OK")
                .data(modulesList.stream().map(this.modulesMapper::toDto).toList())
                .build();
    }
}
