package com.example.clase23.service;

import com.example.clase23.dto.TurnoDTO;
import com.example.clase23.entities.Odontologo;
import com.example.clase23.entities.Paciente;
import com.example.clase23.entities.Turno;
import com.example.clase23.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;
    public List<TurnoDTO> listarTurnos(){
        List<Turno> turnosEncontrados = turnoRepository.findAll();
        //necesito recorrer esta lista para ir pasando de un lugar a otro
        List<TurnoDTO> turnoDTOLista = new ArrayList<>();
        for (Turno turno: turnosEncontrados) {
            turnoDTOLista.add(turnoAturnoDTO(turno));
                 }
        return turnoDTOLista;
    }
    public Optional<TurnoDTO> buscarPorID(Long id){
        Optional<Turno> turnoBuscado= turnoRepository.findById(id);
        if(turnoBuscado.isPresent()){
            //el turno existe
            return Optional.of(turnoAturnoDTO(turnoBuscado.get()));
        }else{
            //es nulo
            return Optional.empty();
        }
    }
    public TurnoDTO guardarTurno(Turno turno){
        Turno turnoGuardado= turnoRepository.save((turno));
        return turnoAturnoDTO(turnoGuardado);
    }
    public void eliminarTurno(Long id){
        turnoRepository.deleteById(id);
    }
    public void actualizarTurno(Turno  turno){
        turnoRepository.save((turno));
    }
    private TurnoDTO turnoAturnoDTO(Turno turno){
        //necesitamos convertirlo
        TurnoDTO turnoDTO= new TurnoDTO();
        //necesitamos ahora cargarle la informacion
        turnoDTO.setId(turno.getId());
        turnoDTO.setFecha(turno.getFecha());
        turnoDTO.setPacienteId(turno.getPaciente().getId());
        turnoDTO.setOdontologoId(turno.getOdontologo().getId());
        //devolverlo
        return turnoDTO;
    }
    private Turno turnoDTOaTurno(TurnoDTO turnoDTO){
        //convertir
        Turno turno = new Turno();
        //ahora necesitamos cargar la info
        Odontologo odontologo= new Odontologo();
        Paciente paciente= new Paciente();
        odontologo.setId(turnoDTO.getOdontologoId());
        paciente.setId(turnoDTO.getPacienteId());
        turno.setId(turnoDTO.getId());
        turno.setFecha(turnoDTO.getFecha());
        //necesito devolverlos
        return  turno;

    }
}
