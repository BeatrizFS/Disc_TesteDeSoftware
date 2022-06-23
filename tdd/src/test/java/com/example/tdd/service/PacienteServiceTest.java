package com.example.tdd.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.tdd.model.PacienteModel;
import com.example.tdd.model.TelefoneModel;
import com.example.tdd.repository.PacientesRepository;
import com.example.tdd.servico.exception.CPFUnicoException;
import com.example.tdd.servico.exception.TelefoneNaoEncontradoException;
import com.example.tdd.servico.exception.TelefoneUnicoException;
import com.example.tdd.servico.impl.PacienteServiceImpl;


@RunWith(SpringRunner.class)
public class PacienteServiceTest{

    private static final String NOME = "Oliver Santos";
    private static final String CPF = "123.456.789-12";
    private static final String DDD = "55";
    private static final String NUMERO = "123456789";


    @MockBean
    private PacientesRepository pacientesRepository;
    
    private PacienteServiceImpl sut;

    private PacienteModel pacienteModel;
    private TelefoneModel telefoneModel;

    @Before
    public void setup() throws Exception{
        sut = new PacienteServiceImpl(pacientesRepository);
        pacienteModel = new PacienteModel();
        pacienteModel.setNome(NOME);
        pacienteModel.setCpf(CPF);

        telefoneModel = new TelefoneModel();
        telefoneModel.setDdd(DDD);
        telefoneModel.setNumero(NUMERO);
        
        pacienteModel.setTelefoneModel(Arrays.asList(telefoneModel));

        when(pacientesRepository.findByCpf(CPF)).thenReturn(Optional.empty());
        when(pacientesRepository.findByTelefoneDDDeNumero(DDD, NUMERO)).thenReturn(Optional.empty());

    }

    //Salvar paciente
    @Test
    public void deveSalvarPacientesNoRepositorio() throws Exception, TelefoneUnicoException{
        sut.salvar(pacienteModel);

        verify(pacientesRepository).save(pacienteModel);
    }

    //Não salvar pacientes com mesmo CPF
    @Test(expected = CPFUnicoException.class)
    public void naoDeveSalvarDuasPessoasComMesmoCPF() throws Exception, TelefoneUnicoException{
        when(pacientesRepository.findByCpf(CPF)).thenReturn(Optional.of(pacienteModel));
    
        sut.salvar(pacienteModel);
    }

    @Test(expected = TelefoneNaoEncontradoException.class)
    public void deveRetornar_NaoEncontrado_SeNaoHouverTelefone() throws Exception {
        sut.buscaPorTelefone(telefoneModel);

    }
    
    @Test(expected = TelefoneUnicoException.class)
    public void naoDeveSalvaDuasPessoasComMesmoTelefone() throws Exception, TelefoneUnicoException{
        when(pacientesRepository.findByTelefoneDDDeNumero(DDD, NUMERO)).thenReturn(Optional.of(pacienteModel));

        sut.salvar(pacienteModel);
    }

    @Test
    public void ProcurarPacientePeloTelefone() throws Exception {
        when(pacientesRepository.findByTelefoneDDDeNumero(DDD, NUMERO)).thenReturn(Optional.of(pacienteModel));
        
        PacienteModel pacienteTeste = sut.buscaPorTelefone(telefoneModel);

        verify(pacientesRepository).findByTelefoneDDDeNumero(DDD, NUMERO);

        assertThat(pacienteTeste).isNotNull();
        //assertThat(pacienteTeste).isEqualTo(NOME);
        //assertThat(pacienteTeste).isEqualTo(CPF);
    }

}