package com.rollerspeed.rollerspeed.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.rollerspeed.rollerspeed.Model.horario;

@Service
public interface HorarioService {

    horario crearHorario(horario horario);
    
    List<horario> MostrarHorarios();
    
    horario obtenerHorario(Long id);
        
    horario modificarHorario(horario horario);
        
    void eliminarHorario(Long id);
}

    

