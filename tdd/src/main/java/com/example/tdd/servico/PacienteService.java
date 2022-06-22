package com.example.tdd.servico;

import com.example.tdd.model.PacienteModel;
import com.example.tdd.servico.exception.CPFUnicoException;

public interface PacienteService {
    PacienteModel salvar (PacienteModel pacienteModel) throws CPFUnicoException;

}
