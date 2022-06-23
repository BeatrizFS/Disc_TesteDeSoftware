package com.example.tdd.servico;

import com.example.tdd.model.PacienteModel;
import com.example.tdd.model.TelefoneModel;
import com.example.tdd.servico.exception.CPFUnicoException;
import com.example.tdd.servico.exception.TelefoneUnicoException;


public interface PacienteService {
    PacienteModel salvar (PacienteModel pacienteModel) throws CPFUnicoException, TelefoneUnicoException;

    PacienteModel buscaPorTelefone(TelefoneModel telefoneModel);
}
