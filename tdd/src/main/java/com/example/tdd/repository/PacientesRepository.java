package com.example.tdd.repository;

import com.example.tdd.model.PacienteModel;
import java.util.Optional;

public interface PacientesRepository {
    PacienteModel save (PacienteModel pacienteModel);

    Optional<PacienteModel> findByCpf(String cpf);
    
}
