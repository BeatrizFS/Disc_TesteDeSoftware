package com.example.tdd.repository;

import com.example.tdd.model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<PacienteModel, String> {

    Optional<PacienteModel> findByReserveName(String nome);
}
