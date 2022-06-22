package com.example.tdd.model;

import java.time.LocalDate;
import java.util.List;


public class PacienteModel {
    private String id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone = "";
    private String especialidade;
    private String hora;
    private LocalDate dataAgenda;
    private LocalDate dataConsulta;
    private List<EnderecoModel> endereco;
    private List<ConsultaModel> consultaModels;
    private List<TelefoneModel> telefoneModels;

    /*
    public PacienteModel() {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.especialidade = especialidade;
        this.hora = hora;
        this.dataAgenda = dataAgenda;
        this.dataConsulta = dataConsulta;
    }
    */

        /*
            if(!telefone.matches("\\d{5}-\\d{4}")){
            throw new IllegalArgumentException("Telefone inválido");
        }
    */
	public String getId() {
        return id;
    }

    public void setId(String id) {
        if(!id.matches("\\d{5}.\\d{1}")){
            throw new IllegalArgumentException("Id inválido");
        }
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(!cpf.matches("\\d{3}.\\d{3}.\\d{3}=\\d{2}")){
            throw new IllegalArgumentException("CPF inválido");
        }

        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone)  {
        if(!telefone.matches("\\d{5}-\\d{4}")){
            throw new IllegalArgumentException("Telefone inválido");
        }

        this.telefone = telefone;
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

    public List<EnderecoModel> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<EnderecoModel> endereco) {
        this.endereco = endereco;
    }

    public List<ConsultaModel> getConsultaModels() {
        return consultaModels;
    }


    public void setConsultaModels(List<ConsultaModel> consultaModels) {
        this.consultaModels = consultaModels;
    }

    public List<TelefoneModel> getTelefoneModels() {
		return telefoneModels;
	}

    /*
	public void setTelefoneModels(List<TelefoneModel> list) {
		this.telefoneModels = list;
	}

	public void setTelefoneModels(List<telefoneModel> asList) {
	}
    */
}
