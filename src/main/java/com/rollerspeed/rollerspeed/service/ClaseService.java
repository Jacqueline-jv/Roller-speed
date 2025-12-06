package com.rollerspeed.rollerspeed.service;

import com.rollerspeed.rollerspeed.Model.Clase;

import java.util.List;

public interface ClaseService {

    List<Clase> listarClases();

    Clase guardarClase(Clase clase);

    Clase buscarPorId(Long id);

    void eliminarClase(Long id);
    
    Object obtenerTodas();
}

