package com.rollerspeed.rollerspeed.service.impl;

import com.rollerspeed.rollerspeed.Model.Instructor;
import com.rollerspeed.rollerspeed.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public List<com.rollerspeed.rollerspeed.repository.Instructor> listarTodos() {
        return instructorRepository.findAll();
    }

    @SuppressWarnings("unchecked")
    public <S> Instructor guardar(Instructor instructor) {
        return (Instructor) instructorRepository save;((Iterable<S>) instructor);
    }

    public Optional<Instructor> obtenerPorId(Long id) {
        return Optional.empty();
    }

    public void eliminar(Long id) {
        instructorRepository.deleteById(id);
    }
}
