package com.example.tdd.repository;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.tdd.model.PacienteModel;

@Sql(value = "/load-database.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/clean-database-sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@RunWith(SpringRunner.class)
@DataJdbcTest
@TestPropertySource("classpath:application-test.properties")
public class PacienteRepositoryTest {

    @Autowired
    private PacientesRepository sut;

    @Test
    public void deveProcurarPessoaPeloCPF() throws Exception {
        Optional <PacienteModel> optional = sut.findByCpf("123.456.789-14");
        assertThat(optional.isPresent()).isTrue();
        
        PacienteModel pacienteModel = optional.get();
        assertThat(pacienteModel.getNome()).isEqualTo("Ana");
        assertThat(pacienteModel.getCpf()).isEqualTo("123.456.789-14");
    }

    @Test
    public void naoDeveEncontrarPacienteComCPFInexistente() throws Exception {
        Optional<PacienteModel> optional = sut.findByCpf("123.829.182-92");

        assertThat(optional.isPresent()).isFalse();
    }
    
}
