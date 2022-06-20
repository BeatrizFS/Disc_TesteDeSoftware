package com.example.tdd;

import com.example.tdd.model.PacienteModel;
import com.example.tdd.repository.PacienteRepository;
import com.example.tdd.servico.PacienteServico;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Optional;

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

    @MockBean
    PacienteRepository pacienteRepository;

    @Test
    //Teste1
    public void pacienteTestServicoDiasCalulador(){
        String nome = "Oliver";
        int dias = pacienteServico.diasCalculadorComDatabase(nome);

        //int i = 10;
        Assertions.assertEquals(dias, 15);

    }

    @Before
    public void setup(){
        LocalDate dataAgenda = LocalDate.parse("2022-11-10");
        LocalDate dataConsulta = LocalDate.parse("2022-11-20");
        PacienteModel pacienteModel = new PacienteModel("1","Oliver","1234578910",
                "oliver@gamil.com","123456789","odontopediatria","12:30",dataAgenda,dataConsulta);

        //Mockito usado para simular Database
        Mockito.when(pacienteRepository.findByReserveName(pacienteModel.getNome()))
                .thenReturn(Optional.of(pacienteModel));
    }
}
