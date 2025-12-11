package com.rollerspeed.rollerspeed.service;

import com.rollerspeed.rollerspeed.Model.User;
import java.util.List;

public interface UserService {

    // Crear usuario general
    User crearUsuario(User user);

    // Crear según rol
    User crearAdmin(User user);
    User crearInstructor(User user);
    User crearAlumno(User user);

    // Buscar usuario
    User buscarPorId(Long id);
    User buscarPorUsername(String username);

    // Validar contraseña
    boolean validarPassword(String raw, String encoded);

    // Listar todos
    List<User> listarUsuarios();

    // Listar instructores
    List<User> listarInstructores();

    // Actualizar usuario
    void actualizarUsuario(User user);   
} 
