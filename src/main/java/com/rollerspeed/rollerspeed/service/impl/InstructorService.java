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

    // Listar todos los instructores
    public List<Instructor> listarTodos() {
        return instructorRepository.findAll();
    }

    // Guardar un instructor
    public Instructor guardar(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    // Obtener instructor por ID
    public Optional<Instructor> obtenerPorId(Long id) {
        return instructorRepository.findById(id);
    }

    // Eliminar instructor por ID
    public void eliminar(Long id) {
        instructorRepository.deleteById(id);
    }
}
