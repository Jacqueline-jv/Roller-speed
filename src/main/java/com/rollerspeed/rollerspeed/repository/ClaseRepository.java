package com.rollerspeed.rollerspeed.repository;

import com.rollerspeed.rollerspeed.Model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Long> {

    // Buscar por username del instructor
    List<Clase> findByInstructor(String instructor);
}