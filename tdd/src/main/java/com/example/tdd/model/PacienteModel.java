package com.example.tdd.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pacientes")
public class PacienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }


    @Column(length = 7, nullable = false)
    private String id;

    @Column(length = 90, nullable = false)
    private String nome;

    @Column(length = 14, nullable = false)
    private String cpf;

    @Column(length = 60, nullable = false)
    private String email;

    private String telefone = "";
    
    @OneToMany(mappedBy = "paciente")
    private List<EnderecoModel> endereco;

    @OneToMany(mappedBy = "paciente")
    private List<TelefoneModel> telefoneModel;

    @OneToMany(mappedBy = "paciente")
    private List<ConsultaModel> consultaModels;

    //Strings seram movidas para o ConsultaModel
    private LocalDate dataAgenda;
    private LocalDate dataConsulta;
    

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

    public List<TelefoneModel> getTelefoneModel() {
        return telefoneModel;
    }

    public void setTelefoneModel(List<TelefoneModel> telefoneModel) {
        this.telefoneModel = telefoneModel;
    }

    /*
            if(!telefone.matches("\\d{5}-\\d{4}")){
            throw new IllegalArgumentException("Telefone inválido");
        }
    */
	public String getId() {
        return id;
    }

    public void setId(String id) {
        if(!id.matches("\\d{5}-\\d{1}")){
            throw new IllegalArgumentException("Id inválido");
        }
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        /*
        if(!nome.matches("")){
            throw new IllegalArgumentException("Nome nulo");

        this.nome = nome;
        */
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        
        if(!cpf.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}")){
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
        if(!telefone.matches("\\d{2}\\d{5}-\\d{4}")){
            throw new IllegalArgumentException("Telefone inválido");
        }

        this.telefone = telefone;
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

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        PacienteModel pacienteModel = (PacienteModel) o;

        return getCodigo() != null ? getCodigo().equals(pacienteModel.getCodigo()) : pacienteModel.getCodigo() == null;
    }

    @Override
    public int hashCode(){
        return getCodigo() != null ? getClass().hashCode() : 0;
    }
    
}
