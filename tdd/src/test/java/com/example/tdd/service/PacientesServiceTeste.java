package com.example.tdd.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.tdd.model.PacienteModel;
import com.example.tdd.repository.PacientesRepository;
import com.example.tdd.servico.PacientesService;

@RunWith(MockitoJUnitRunner.class)
public class PacientesServiceTeste {
    
    @Mock
    private PacientesRepository pacientesRepository;

    @InjectMocks
    private PacientesService pacientesService;
    
    @Test
    public void testSalvarComSucesso () {
        PacienteModel pacienteModel = new PacienteModel();
        pacienteModel.setNome("");
        pacienteModel.setEmail("teste@gmail.com");
        pacientesService.save(pacienteModel);
        verify(pacientesRepository, times(1)).save(pacienteModel);
    }

    @Test(expected = Exception.class)
    public void testCamposObrigatoriosInvalidos(){
        PacienteModel pacienteModel = new PacienteModel();
        pacientesService.save(pacienteModel);
    }
}
