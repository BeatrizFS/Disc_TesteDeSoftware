package com.example.tdd.servico.impl;

import com.example.tdd.model.PacienteModel;
import com.example.tdd.repository.PacientesRepository;
import com.example.tdd.servico.PacienteService;

public class PacienteServiceImpl implements PacienteService{
    
    private final PacientesRepository pacientesRepository;

	public PacienteServiceImpl(PacientesRepository pacientesRepository){
        this.pacientesRepository = pacientesRepository;
    }

    @Override
    public PacienteModel salvar(PacienteModel pacienteModel) {
        return pacientesRepository.save(pacienteModel);
    }
    
}
