package com.example.tdd.service;

import org.aspectj.lang.annotation.Before;

import com.example.tdd.servico.PacienteService;
import com.example.tdd.servico.PacienteServiceImp;
import org.junit.Before;

public class PacienteServiceTest{
    
    private PacienteService sut;

    @Before
    public void setUp() throws Exception{
        sut = new PacienteServiceImp();
    }

}