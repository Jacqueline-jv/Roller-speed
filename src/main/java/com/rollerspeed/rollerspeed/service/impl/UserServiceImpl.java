package com.rollerspeed.rollerspeed.service.impl;

import com.rollerspeed.rollerspeed.Model.User;
import com.rollerspeed.rollerspeed.repository.UserRepository;
import com.rollerspeed.rollerspeed.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // ✔ Crear usuario general
    @Override
    public User crearUsuario(User user) {
        // Encriptar contraseña
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Guardar usuario
        return userRepository.save(user);
    }

    // ✔ Crear admin
    @Override
    public User crearAdmin(User user) {
        user.setRole("ADMIN");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // ✔ Crear instructor
    @Override
    public User crearInstructor(User user) {
        user.setRole("INSTRUCTOR");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // ✔ Crear alumno
    @Override
    public User crearAlumno(User user) {
        user.setRole("ALUMNO");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // ✔ Buscar por ID
    @Override
    public User buscarPorId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // ✔ Buscar por username (para login)
    @Override
    public User buscarPorUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    // ✔ Validar contraseña para login
    @Override
    public boolean validarPassword(String raw, String encoded) {
        return passwordEncoder.matches(raw, encoded);
    }

    // ✔ Listar usuarios
    @Override
    public List<User> listarUsuarios() {
        return userRepository.findAll();
    }

    // Modificar usuario por Id
    @Override
    public User modificarUsuario(Long id, User user) {
        User usuarioExistente = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Usuario no encontrado con ID: " + id));
        
            usuarioExistente.setEmail(user.getEmail());
            usuarioExistente.setNombre(user.getNombre());
            usuarioExistente.setApellido(user.getApellido());
            usuarioExistente.setTelefono(user.getTelefono());
            return userRepository.save(usuarioExistente);
    }
}
