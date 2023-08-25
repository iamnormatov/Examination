package com.example.validation.controller;

import com.example.validation.dto.LessonsDto;
import com.example.validation.dto.ResponseDto;
import com.example.validation.dto.SimpleCRUD;
import com.example.validation.service.LessonsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "lessons")
public class LessonsController implements SimpleCRUD<Integer, LessonsDto> {

    private final LessonsService lessonsService;

    @PostMapping(value = "/create")
    @Override
    public ResponseDto<LessonsDto> create(@RequestBody @Valid LessonsDto dto) {
        return this.lessonsService.create(dto);
    }

    @GetMapping(value = "/get/{id}")
    @Override
    public ResponseDto<LessonsDto> get(@PathVariable(name = "id") Integer entityId) {
        return this.lessonsService.get(entityId);
    }

    @PutMapping(value = "/update/{id}")
    @Override
    public ResponseDto<LessonsDto> update(@RequestBody @Valid LessonsDto dto, @PathVariable(name = "id") Integer entityId) {
        return this.lessonsService.update(dto, entityId);
    }

    @DeleteMapping(value = "/delete/{id}")
    @Override
    public ResponseDto<LessonsDto> delete(@PathVariable(name = "id") Integer entityId) {
        return this.lessonsService.delete(entityId);
    }

    @GetMapping(value = "/search-all-name")
    public ResponseDto<List<LessonsDto>> searchUserByName(@RequestParam String value){
        return this.lessonsService.searchUserByName(value);
    }
}
