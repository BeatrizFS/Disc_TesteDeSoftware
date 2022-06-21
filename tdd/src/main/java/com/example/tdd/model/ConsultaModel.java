package com.example.tdd.model;

import java.time.LocalDate;

public class ConsultaModel {
    
    private String medico;
    private String especialidade;
    private String hora;
    private LocalDate dataAgenda;
    private LocalDate dataConsulta;
    private String protocolo;


	public ConsultaModel(String medico, String especialidade, String hora, LocalDate dataAgenda,
            LocalDate dataConsulta, String protocolo) {
        this.medico = medico;
        this.especialidade = especialidade;
        this.hora = hora;
        this.dataAgenda = dataAgenda;
        this.dataConsulta = dataConsulta;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public LocalDate getDataAgenda() {
        return dataAgenda;
    }

    public void setDataAgenda(LocalDate dataAgenda) {
        this.dataAgenda = dataAgenda;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }


	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

}
