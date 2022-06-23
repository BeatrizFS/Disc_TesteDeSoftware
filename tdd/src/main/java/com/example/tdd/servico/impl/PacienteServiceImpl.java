package com.example.tdd.servico.impl;

import java.util.Optional;

import com.example.tdd.model.PacienteModel;
import com.example.tdd.model.TelefoneModel;
import com.example.tdd.repository.PacientesRepository;
import com.example.tdd.servico.PacienteService;
import com.example.tdd.servico.exception.CPFUnicoException;

public class PacienteServiceImpl implements PacienteService{
    
    private final PacientesRepository pacientesRepository;

	public PacienteServiceImpl(PacientesRepository pacientesRepository){
        this.pacientesRepository = pacientesRepository;
    }

    @Override
    public PacienteModel salvar(PacienteModel pacienteModel) throws CPFUnicoException {

        Optional<PacienteModel> optional = pacientesRepository.findByCpf(pacienteModel.getCpf());

        if( optional.isPresent() ){
            throw new CPFUnicoException();
        }

        return pacientesRepository.save(pacienteModel);
    }

    @Override
    public PacienteModel buscaPorTelefone(TelefoneModel telefoneModel) {
        return null;
    }
    
    
}
