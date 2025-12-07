package com.rollerspeed.rollerspeed.service;

import com.rollerspeed.rollerspeed.Model.User;
import java.util.List;

public interface UserService {

    // ✔ Crear usuario general (alumno, instructor, admin)
    User crearUsuario(User user);

    // ✔ Métodos individuales (si deseas usarlos después)
    User crearAdmin(User user);
    User crearInstructor(User user);
    User crearAlumno(User user);

    // ✔ Buscar usuario por ID
    User buscarPorId(Long id);

    // ✔ Buscar usuario por username (para login)
    User buscarPorUsername(String username);

    // ✔ Validar contraseña (login)
    boolean validarPassword(String raw, String encoded);

    // ✔ Listar todos los usuarios
    List<User> listarUsuarios();

    // Modificar usuario por Id
    User modificarUsuario(Long id, User user);
}
