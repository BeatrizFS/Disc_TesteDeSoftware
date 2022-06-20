package com.example.tdd;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PacienteServicoTest {

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
