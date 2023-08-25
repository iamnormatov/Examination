package com.example.validation.modules;

import com.example.validation.dto.CoursesDto;
import com.example.validation.dto.LessonsDto;
import com.example.validation.dto.ModulesDto;
import com.example.validation.dto.ResponseDto;
import com.example.validation.model.Courses;
import com.example.validation.model.Modules;
import com.example.validation.repository.CoursesRepository;
import com.example.validation.repository.ModulesRepository;
import com.example.validation.service.CoursesService;
import com.example.validation.service.ModulesService;
import com.example.validation.service.mapper.CoursesMapper;
import com.example.validation.service.mapper.ModulesMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.MDC;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class TestModules {
    private ModulesService modulesService;
    private ModulesMapper modulesMapper;

    private ModulesRepository modulesRepository;
    private CoursesRepository coursesRepository;
    @BeforeEach
    void initObject(){
        modulesMapper = mock(ModulesMapper.class);
        modulesRepository = mock(ModulesRepository.class);
        coursesRepository = mock(CoursesRepository.class);
        modulesService = new ModulesService(modulesMapper, modulesRepository, coursesRepository);
    }

    @Test
    void testCreatePositive(){
        when(this.modulesMapper.toEntity(any()))
                .thenReturn(Modules.builder()
                        .moduleId(1)
                        .name("Azizjon")
                        .price(1)
                        .build());
        when(this.modulesMapper.toDto(any()))
                .thenReturn(ModulesDto.builder()
                        .moduleId(1)
                        .name("Azizjon")
                        .price(1)
                        .build());

        ResponseDto<ModulesDto> responseDto =this.modulesService.create(any());

        Assertions.assertEquals(responseDto.getCode(), 0);
        Assertions.assertTrue(responseDto.isSuccess());
        Assertions.assertNotNull(responseDto.getData());
        Assertions.assertNull(responseDto.getError());

        verify(this.modulesMapper, times(1)).toDto(any());
        verify(this.modulesRepository, times(1)).save(any());
    }
    @Test
    void testCreateNegative(){
        when(this.modulesRepository.getModulesById(any()))
                .thenReturn(Optional.empty());

        ResponseDto<ModulesDto> response = this.modulesService.get(any());

        Assertions.assertEquals(response.getCode(), -1);
        Assertions.assertNull(response.getData());
        Assertions.assertFalse(response.isSuccess());

        verify(this.modulesRepository, times(1)).save(any());
    }
    @Test
    void testCreateException(){
        when(this.modulesService.create(any()))
                .thenThrow(RuntimeException.class);

        ResponseDto<ModulesDto> responseDto = this.modulesService.create(any());

        Assertions.assertNull(responseDto.getData());
        Assertions.assertEquals(-2, responseDto.getCode());
    }
    @Test
    void testGetPositive(){
        when(modulesMapper.toDtoWithLesson(any()))
                .thenReturn(ModulesDto.builder()
                        .moduleId(2)
                        .name("Hasanboy")
                        .price(1)
                        .build());

        when(this.modulesRepository.getModulesById(any()))
                .thenReturn(Optional.ofNullable(Modules.builder()
                        .moduleId(1)
                        .name("Hasanboy")
                        .price(1)
                        .build()));

        ResponseDto<ModulesDto> response = this.modulesService.get(any());

        Assertions.assertEquals(response.getCode(), 0);
        Assertions.assertTrue(response.isSuccess());
        Assertions.assertNotNull(response.getData());
        Assertions.assertEquals(response.getData().getCourseId(), 2);

        verify(this.modulesRepository, times(1)).getModulesById(any());
        verify(this.modulesMapper, times(1)).toDtoWithLesson(any());
    }
    @Test
    void testGetNegative(){
        when(this.modulesRepository.getModulesById(any()))
                .thenReturn(Optional.empty());

        ResponseDto<ModulesDto> response = this.modulesService.get(any());

        Assertions.assertEquals(response.getCode(), -1);
        Assertions.assertNull(response.getData());
        Assertions.assertFalse(response.isSuccess());

        verify(this.modulesRepository, times(1)).getModulesById(any());
    }
    @Test
    void testUpdatePositive(){
        when(modulesMapper.update(any(), any()))
                .thenReturn(Modules.builder()
                        .moduleId(2)
                        .name("Hasanboy")
                        .price(1)
                        .build());

        when(modulesMapper.toDto(any()))
                .thenReturn(ModulesDto.builder()
                        .moduleId(3)
                        .name("Hasanboy")
                        .price(1)
                        .build());

        when(this.modulesRepository.getModulesById(any()))
                .thenReturn(Optional.ofNullable(Modules.builder()
                        .moduleId(1)
                        .name("Hasanboy")
                        .price(1)
                        .build()));

        ResponseDto<ModulesDto> response = this.modulesService.update(any(), any());


        Assertions.assertEquals(response.getCode(), 0);
        Assertions.assertTrue(response.isSuccess());
        Assertions.assertEquals(response.getData().getCourseId(), 3);

        verify(this.modulesMapper, times(1)).toDto(any());
        verify(this.modulesMapper, times(1)).update(any(), any());
        verify(this.modulesRepository, times(1)).save(any());
        verify(this.modulesRepository, times(1)).getModulesById(any());
    }
    @Test
    void testUpdateNegative(){
        when(this.modulesRepository.getModulesById(any()))
                .thenReturn(Optional.empty());

        ResponseDto<ModulesDto> response = this.modulesService.update(any(), any());

        Assertions.assertEquals(response.getCode(), -1);
        Assertions.assertNull(response.getData());
        Assertions.assertFalse(response.isSuccess());
        Assertions.assertEquals(response.getMessage(), "Modules are not found!");

        verify(this.modulesRepository, times(1)).getModulesById(any());
    }
    @Test
    void testUpdateException() {
        when(modulesMapper.toDto(any()))
                .thenThrow(RuntimeException.class);

        ResponseDto<ModulesDto> response = this.modulesService.update(any(), any());

        Assertions.assertEquals(response.getCode(), -2);
        Assertions.assertFalse(response.isSuccess());
        Assertions.assertNull(response.getData());
        Assertions.assertNull(response.getError());

        verify(this.modulesRepository, times(1)).getModulesById(any());
    }
    @Test
    void testDeletePositive(){
        when(modulesMapper.toDto(any()))
                .thenReturn(ModulesDto.builder()
                        .moduleId(3)
                        .name("Hasanboy")
                        .price(1)
                        .build());

        when(this.modulesRepository.getModulesById(any()))
                .thenReturn(Optional.ofNullable(Modules.builder()
                        .moduleId(1)
                        .name("Hasanboy")
                        .price(1)
                        .build()));

        ResponseDto<ModulesDto> response = this.modulesService.delete(any());

        Assertions.assertEquals(response.getCode(), 0);
        Assertions.assertTrue(response.isSuccess());
        Assertions.assertEquals(response.getData().getCourseId(), 3);

        verify(this.modulesMapper, times(1)).toDto(any());
        verify(this.modulesRepository, times(1)).save(any());
        verify(this.modulesRepository, times(1)).getModulesById(any());
    }
    @Test
    void testDeleteNegative(){
        when(this.modulesRepository.getModulesById(any()))
                .thenReturn(Optional.empty());

        ResponseDto<ModulesDto> response = this.modulesService.delete(any());

        Assertions.assertEquals(response.getCode(), -1);
        Assertions.assertNull(response.getData());
        Assertions.assertFalse(response.isSuccess());
        Assertions.assertEquals(response.getMessage(), "Modules are not found!");

        verify(this.modulesRepository, times(1)).getModulesById(any());
    }
    @Test
    void testDeleteException(){
        when(modulesMapper.toDto(any()))
                .thenThrow(RuntimeException.class);

        ResponseDto<ModulesDto> response = this.modulesService.delete(any());

        Assertions.assertEquals(response.getCode(), -2);
        Assertions.assertFalse(response.isSuccess());
        Assertions.assertNull(response.getData());
        Assertions.assertNull(response.getError());

        verify(this.modulesRepository, times(1)).getModulesById(any());
    }
}
