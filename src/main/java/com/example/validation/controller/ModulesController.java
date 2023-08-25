package com.example.validation.controller;

import com.example.validation.dto.CoursesDto;
import com.example.validation.dto.ModulesDto;
import com.example.validation.dto.ResponseDto;
import com.example.validation.dto.SimpleCRUD;
import com.example.validation.service.ModulesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "modules")
public class ModulesController implements SimpleCRUD<Integer, ModulesDto> {

    private final ModulesService modulesService;

    @PostMapping(value = "/create")
    @Override
    public ResponseDto<ModulesDto> create(@RequestBody @Valid ModulesDto dto) {
        return this.modulesService.create(dto);
    }

    @GetMapping(value = "/get/{id}")
    @Override
    public ResponseDto<ModulesDto> get(@PathVariable(name = "id") Integer entityId) {
        return this.modulesService.get(entityId);
    }

    @PutMapping(value = "/update/{id}")
    @Override
    public ResponseDto<ModulesDto> update(@RequestBody @Valid ModulesDto dto,  @PathVariable(name = "id") Integer entityId) {
        return this.modulesService.update(dto, entityId);
    }

    @DeleteMapping(value = "/delete/{id}")
    @Override
    public ResponseDto<ModulesDto> delete(@PathVariable(name = "id") Integer entityId) {
        return this.modulesService.delete(entityId);
    }

    @GetMapping(value = "/search-all-name")
    public ResponseDto<List<ModulesDto>> searchUserByName(@RequestParam String value){
        return this.modulesService.searchUserByName(value);
    }
}
