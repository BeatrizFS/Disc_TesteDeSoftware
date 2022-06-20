package com.example.tdd;

import com.example.tdd.model.PacienteModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PacienteControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void pacienteTestGetAll() throws Exception{
        mockMvc.perform(get("/paciente"))
                .andExpect(status().isOk());
    }

    @Test
    public void pacienteTesteSave() throws Exception {
        LocalDate dataAgenda = LocalDate.parse("2022-11-10");
        LocalDate dataConsulta = LocalDate.parse("2022-11-20");
        PacienteModel pacienteModel = new PacienteModel(
        );

        mockMvc.perform(post("/paciente")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(pacienteModel)))
                .andExpect(status().isOk());

    }

}
