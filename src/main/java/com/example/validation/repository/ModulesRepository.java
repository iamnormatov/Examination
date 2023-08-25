package com.example.validation.repository;

import com.example.validation.model.Courses;
import com.example.validation.model.Modules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModulesRepository extends JpaRepository<Modules, Integer> {
    @Query(
            value = "select * from modules where modules_id = ?1",
            nativeQuery = true
    )
    Optional<Modules> getModulesById(Integer modulesId);

    @Query(name = "searchByNameThree")
    List<Modules> searchUserByName(@Param(value = "val") String value);
}
