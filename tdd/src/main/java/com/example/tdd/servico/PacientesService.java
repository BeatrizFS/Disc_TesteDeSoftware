package com.example.tdd.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tdd.model.PacienteModel;
import com.example.tdd.repository.PacientesRepository;

@Service
public class PacientesService {
    
    @Autowired
    private PacientesRepository pacientesRepository;

    public void save (PacienteModel pacienteModel){
        validarCampos(pacienteModel);
        pacientesRepository.save(pacienteModel);
    }

    private void validarCampos(PacienteModel pacienteModel){
        if(pacienteModel.getEmail() == null || pacienteModel.getNome() == null)
            throw new RuntimeException("Campos obrigatórios ...");
    }
}
