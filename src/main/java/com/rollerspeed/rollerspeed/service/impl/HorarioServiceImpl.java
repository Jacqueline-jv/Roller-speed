package com.rollerspeed.rollerspeed.service.impl;
import com.rollerspeed.rollerspeed.Model.horario;
import com.rollerspeed.rollerspeed.service.HorarioService;
import com.rollerspeed.rollerspeed.repository.horarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HorarioServiceImpl implements HorarioService {
    
    private final horarioRepository horarioRepository;
    
    public HorarioServiceImpl(horarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    @Override
    public horario crearHorario(horario horario) {
        return horarioRepository.save(horario);
    }

    @Override
    public List<horario> MostrarHorarios() {
        return horarioRepository.findAll();
    }

    @Override
    public horario obtenerHorario(Long id) {
        return horarioRepository.findById(id).orElse(null);
    }

    @Override
    public horario modificarHorario(horario horario) {
        return horarioRepository.save(horario);
    }

    @Override
    public void eliminarHorario(Long id) {
        horarioRepository.deleteById(id);
    }
  
}
