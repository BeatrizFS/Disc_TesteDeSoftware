package com.example.tdd.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.tdd.model.PacienteModel;
import com.example.tdd.repository.PacientesRepository;
import com.example.tdd.servico.exception.CPFUnicoException;
import com.example.tdd.servico.impl.PacienteServiceImpl;


@RunWith(SpringRunner.class)
public class PacienteServiceTest{

    private static final String NOME = "Oliver Santos";
    private static final String CPF = "12345678912";


    @MockBean
    private PacientesRepository pacientesRepository;
    
    private PacienteServiceImpl sut;

    private PacienteModel pacienteModel;

    @Before
    public void setup() throws Exception{
        sut = new PacienteServiceImpl(pacientesRepository);
        pacienteModel = new PacienteModel();
        pacienteModel.setNome(NOME);
        pacienteModel.setCpf(CPF);

        when(pacientesRepository.findByCpf(CPF)).thenReturn(Optional.empty());

    }

    //Salvar paciente
    @Test
    public void deveSalvarPacientesNoRepositorio() throws Exception{
        sut.salvar(pacienteModel);

        verify(pacientesRepository).save(pacienteModel);
    }

    //Não salvar pacientes com mesmo CPF
    @Test(expected = CPFUnicoException.class)
    public void naoDeveSalvarDuasPessoasComMesmoCPF() throws Exception{
        when(pacientesRepository.findByCpf(CPF)).thenReturn(Optional.of(pacienteModel));
    
        sut.salvar(pacienteModel);
    }


}