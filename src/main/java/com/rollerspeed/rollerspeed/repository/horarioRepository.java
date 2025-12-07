package com.rollerspeed.rollerspeed.repository;

import com.rollerspeed.rollerspeed.Model.horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface horarioRepository extends JpaRepository<horario, Long> {
}