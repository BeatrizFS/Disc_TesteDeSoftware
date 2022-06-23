package com.example.tdd.repository;

import com.example.tdd.model.PacienteModel;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientesRepository extends JpaRepository<PacienteModel, Long>{
    
    //PacienteModel save (PacienteModel pacienteModel);

    Optional<PacienteModel> findByCpf(String cpf);
    

    Optional<PacienteModel> findByTelefoneDDDeNumero(String ddd, String numero);
}
