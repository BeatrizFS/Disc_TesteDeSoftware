package com.example.tdd.utilis;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class TelefoneValidatorTest {

    public TelefoneValidador underTest;

    @BeforeEach
    public void setUp(){
        underTest = new TelefoneValidador();
    }


    @Test
    public void itShouldValidadorTelefoneNum(){
        String telefone = "+5581932145678";
        boolean isValid = underTest.test(telefone);
        assertThat(isValid).isTrue();

    }

    @Test
    @DisplayName("Verificar se telefone possui mais do que 13 dígitos")
    public void itShouldValidadorTelefoneNumMaisde13(){
        String telefone = "+5581932145678000";
        boolean isValid = underTest.test(telefone);
        assertThat(isValid).isFalse();

    }

    @Test
    @DisplayName("Verificar se telefone inicia com +")
    public void itShouldValidadorTelefoNotIniciaComSinal(){
        String telefone = "5581932145678000";
        boolean isValid = underTest.test(telefone);
        assertThat(isValid).isFalse();

    }

}
