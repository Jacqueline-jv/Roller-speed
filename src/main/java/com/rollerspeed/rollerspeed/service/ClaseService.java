package com.rollerspeed.rollerspeed.service;

import com.rollerspeed.rollerspeed.Model.Clase;

import java.util.List;

public interface ClaseService {

    Clase crearClase(Clase clase);

    Clase actualizarClase(Long id, Clase clase);

    void eliminarClase(Long id);

    List<Clase> listarClases();

    Clase obtenerClasePorId(Long id);

    Clase asignarInstructor(Long claseId, Long instructorId);

    List<Clase> listarClasesPorInstructor(Long instructorId);
}


