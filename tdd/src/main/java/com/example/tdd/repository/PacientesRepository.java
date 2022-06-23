package com.example.tdd.repository;

import com.example.tdd.model.PacienteModel;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacientesRepository extends JpaRepository<PacienteModel, Long>{
    
    //PacienteModel save (PacienteModel pacienteModel);

    Optional<PacienteModel> findByCpf(String cpf);
    
    @Query("SELECT bean FROM PacienteModel bean WHERE 1=1")
    Optional<PacienteModel> findByTelefoneDDDeNumero(String ddd, String numero);
}
