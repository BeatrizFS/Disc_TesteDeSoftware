package com.example.tdd;

import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PacienteControllerTest {

    @Test
    //Teste 2
    public void pacienteTestGelAll() throws Exception{
        mockMvc.perform(get("/paciente"))
                .andExpect(status().isOk());
    }
}
