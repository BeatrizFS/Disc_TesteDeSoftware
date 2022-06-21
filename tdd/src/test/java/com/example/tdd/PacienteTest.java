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

    /* 
    @Test
    public void testSetTelefoneInvalidoExcecao(){
        final PacienteModel instance = new PacienteModel();
        final String invalido = "123";
        assertThrows(IllegalArgumentException.class,() -> instance.setTelefone(invalido));
    }
    */
    
    @Test
    public void testSetTelefoneInvalidoNaoArmazena(){
        final PacienteModel instance = new PacienteModel();
        final String invalido = "123";
        assertThrows(IllegalArgumentException.class,() -> instance.setTelefone(invalido));
        final String obtido = instance.getTelefone();
        assertNotEquals(invalido, obtido);
    }
}
