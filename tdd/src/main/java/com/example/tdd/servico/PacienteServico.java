package com.example.tdd.servico;

import com.example.tdd.model.PacienteModel;
import com.example.tdd.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Optional;

@Service
public class PacienteServico {

    @Autowired
    PacienteRepository pacienteRepository;

    public int diasCalculadorComDatabase(String nome) {
        Optional<PacienteModel> pacienteModelOptional = pacienteRepository.findByReserveName(nome);

        return Period.between(pacienteModelOptional.get().getDataAgenda(), pacienteModelOptional.get().getDataConsulta()).getDays();
    }
}
