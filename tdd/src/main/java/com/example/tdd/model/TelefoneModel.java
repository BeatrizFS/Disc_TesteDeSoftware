package com.example.tdd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;


@Entity
@Table(name = "telefone")
public class TelefoneModel {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

	@Column(length = 2, nullable = false)
	private String ddd;

	@Column(length = 11, nullable = false)
	private String numero;


	@ManyToOne
	//Identifica o relacionamento
	@JoinColumn(name = "codigo_paciente")
	private PacienteModel pacienteModel;

    public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

    public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        TelefoneModel telefoneModel = (TelefoneModel) o;

        return getCodigo() != null ? getCodigo().equals(telefoneModel.getCodigo()) : telefoneModel.getCodigo() == null;
    }

    @Override
    public int hashCode(){
        return getCodigo() != null ? getClass().hashCode() : 0;
    }
}
