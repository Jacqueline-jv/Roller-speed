package com.rollerspeed.rollerspeed.service.impl;

import com.rollerspeed.rollerspeed.Model.Clase;
import com.rollerspeed.rollerspeed.Model.User;
import com.rollerspeed.rollerspeed.repository.ClaseRepository;
import com.rollerspeed.rollerspeed.repository.UserRepository;
import com.rollerspeed.rollerspeed.service.ClaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseServiceImpl implements ClaseService {

    private final ClaseRepository claseRepository;
    private final UserRepository userRepository;

    public ClaseServiceImpl(ClaseRepository claseRepository, UserRepository userRepository) {
        this.claseRepository = claseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Clase crearClase(Clase clase) {
        return claseRepository.save(clase);
    }

    @Override
    public Clase actualizarClase(Long id, Clase clase) {
        Clase existente = claseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));

        existente.setNombre(clase.getNombre());
        existente.setDescripcion(clase.getDescripcion());
        existente.setFechaHora(clase.getFechaHora());
        existente.setInstructor(clase.getInstructor());

        return claseRepository.save(existente);
    }

    @Override
    public void eliminarClase(Long id) {
        claseRepository.deleteById(id);
    }

    @Override
    public List<Clase> listarClases() {
        return claseRepository.findAll();
    }

    @Override
    public Clase obtenerClasePorId(Long id) {
        return claseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));
    }

    @Override
    public Clase asignarInstructor(Long claseId, Long instructorId) {

        Clase clase = claseRepository.findById(claseId)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));

        User instructor = userRepository.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor no encontrado"));

        if (!"INSTRUCTOR".equalsIgnoreCase(instructor.getRole())) {
            throw new RuntimeException("El usuario NO es instructor");
        }

        clase.setInstructor(instructor.getUsername());

        return claseRepository.save(clase);
    }

    @Override
    public List<Clase> listarClasesPorInstructor(Long instructorId) {

        User instructor = userRepository.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor no encontrado"));

        return claseRepository.findByInstructor(instructor.getUsername());
    }
}

