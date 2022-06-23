package com.example.tdd.model;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
public class EnderecoModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

	@ManyToOne
	//Identifica o relacionamento
	@JoinColumn(name = "codigo_paciente")
    private PacienteModel pacienteModel;


    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }   

    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        EnderecoModel endereModel = (EnderecoModel) o;

        return getCodigo() != null ? getCodigo().equals(endereModel.getCodigo()) : endereModel.getCodigo() == null;
    }

    @Override
    public int hashCode(){
        return getCodigo() != null ? getClass().hashCode() : 0;
    }

}
