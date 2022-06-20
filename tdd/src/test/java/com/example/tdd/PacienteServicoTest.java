package com.example.tdd;

import com.example.tdd.servico.PacienteServico;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.context.annotation.Bean;

@RunWith(SpringRunner.class)
public class PacienteServicoTest {

    @TestConfiguration
    static class PacienteServiceTestConfiguration{
        @Bean
        public PacienteServico pacienteServico(){
            return new PacienteServico();
        }

    }

    @Autowired
    PacienteServico pacienteServico;

    @Test
    //Teste1
    public void pacienteTestServicoDiasCalulador(){
        String nome = "Oliver";
        int dias = pacienteServico.diasCalculadorComDatabase(nome);

        //int i = 10;
        Assertions.assertEquals(dias, 10);
    }
}
