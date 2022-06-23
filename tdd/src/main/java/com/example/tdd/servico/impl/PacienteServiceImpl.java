package com.example.tdd.servico.impl;

import java.util.Optional;

import com.example.tdd.model.PacienteModel;
import com.example.tdd.model.TelefoneModel;
import com.example.tdd.repository.PacientesRepository;
import com.example.tdd.servico.PacienteService;
import com.example.tdd.servico.exception.CPFUnicoException;
import com.example.tdd.servico.exception.TelefoneNaoEncontradoException;
import com.example.tdd.servico.exception.TelefoneUnicoException;

public class PacienteServiceImpl implements PacienteService{
    
    private final PacientesRepository pacientesRepository;

	public PacienteServiceImpl(PacientesRepository pacientesRepository){
        this.pacientesRepository = pacientesRepository;
    }

    @Override
    public PacienteModel salvar(PacienteModel pacienteModel) throws CPFUnicoException, TelefoneUnicoException {

        Optional<PacienteModel> optional = pacientesRepository.findByCpf(pacienteModel.getCpf());

        if( optional.isPresent() ){
            throw new CPFUnicoException();
        }

        final String ddd = pacienteModel.getTelefoneModel().get(0).getDdd();
        final String numero = pacienteModel.getTelefoneModel().get(0).getNumero();
        optional = pacientesRepository.findByTelefoneDDDeNumero(ddd, numero);

        if(optional.isPresent()){
            throw new TelefoneUnicoException();
        }
        
        return pacientesRepository.save(pacienteModel);
    }

    @Override
    public PacienteModel buscaPorTelefone(TelefoneModel telefoneModel) throws TelefoneNaoEncontradoException {
        Optional<PacienteModel> optional = pacientesRepository.findByTelefoneDDDeNumero(telefoneModel.getDdd(), telefoneModel.getNumero());
        return optional.orElseThrow(() -> new TelefoneNaoEncontradoException());
    }
    
    
}
