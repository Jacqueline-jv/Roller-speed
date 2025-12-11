package com.rollerspeed.rollerspeed.service.impl;

import com.rollerspeed.rollerspeed.Model.User;
import com.rollerspeed.rollerspeed.repository.UserRepository;
import com.rollerspeed.rollerspeed.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User crearUsuario(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User crearAdmin(User user) {
        user.setRole("ADMIN");
        return crearUsuario(user);
    }

    @Override
    public User crearInstructor(User user) {
        user.setRole("INSTRUCTOR");
        return crearUsuario(user);
    }

    @Override
    public User crearAlumno(User user) {
        user.setRole("ALUMNO");
        return crearUsuario(user);
    }

    @Override
    public User buscarPorId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User buscarPorUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public boolean validarPassword(String raw, String encoded) {
        return passwordEncoder.matches(raw, encoded);
    }

    @Override
    public List<User> listarUsuarios() {
        return userRepository.findAll();
    }

    @Override
    public List<User> listarInstructores() {
        return userRepository.findByRole("INSTRUCTOR");
    }

    @Override
    public void actualizarUsuario(User user) {
        userRepository.save(user);
    }
}