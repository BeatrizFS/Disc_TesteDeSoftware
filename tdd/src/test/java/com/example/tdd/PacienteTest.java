package com.example.tdd;

import com.example.tdd.model.PacienteModel;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PacienteTest {

    @Test
    public void testSetTelefoneValido(){
        final PacienteModel instance = new PacienteModel();
        final String esperado = "+5581912345678";
        instance.setTelefone(esperado);
        final String obtido = instance.getTelefone();
        assertEquals(esperado, obtido);
    }

    
    @Test
    public void testSetTelefoneInvalidoExcecao(){
        final PacienteModel instance = new PacienteModel();
        final String invalido = "123";
        assertThrows(IllegalArgumentException.class,() -> instance.setTelefone(invalido));
    }
    
    
    @Test
    public void testSetTelefoneInvalidoNaoArmazena(){
        final PacienteModel instance = new PacienteModel();
        final String invalido = "123";
        assertThrows(IllegalArgumentException.class,() -> instance.setTelefone(invalido));
        final String obtido = instance.getTelefone();
        assertNotEquals(invalido, obtido);
    }

    //Validação de CPF
    @Test
    public void testCPFValido(){
        final PacienteModel instance = new PacienteModel();
        final String valido = "123.456.789-10";
        instance.setCpf(valido);
        final String obtido = instance.getCpf();
        assertEquals(valido, obtido);
    }

    @Test
    public void testCPFNaoArmazenado(){
        final PacienteModel instance = new PacienteModel();
        final String invalido = "12345";
        assertThrows(IllegalArgumentException.class,() -> instance.setCpf(invalido));
        final String obtido = instance.getCpf();
        assertNotEquals(invalido, obtido);
    }

    @Test
    public void testNomeVazio(){
        final PacienteModel instance = new PacienteModel();
        final String nulo = null;
        assertThrows(IllegalArgumentException.class,()-> instance.setNome(nulo));

    }

    @Test
    public void testNomeEmBranco(){
        final PacienteModel instance = new PacienteModel();
        final String espacosEmBranco = "   ";
        assertThrows(IllegalArgumentException.class,()-> instance.setNome(espacosEmBranco));
    }

    @Test
    public void testSetIDValido(){
        final PacienteModel instance = new PacienteModel();
        final String valido = "12345-1";
        instance.setId(valido);
        final String obtido = instance.getId();
        assertEquals(valido, obtido);
    }

    /*
    @Test
    public void testIdInvalidoNaoArmazena{
        final PacienteModel instance = new PacienteModel();
        final String invalido = "1234";
        assertThrows(IllegalArgumentException.class,() -> instance.setId(invalido));
        final String obtido = instance.getCpf();
        assertNotEquals(invalido, obtido);
    }
    */
}
