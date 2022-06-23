package com.example.tdd.model;

public class TelefoneModel {
    private String ddd;
	
	public TelefoneModel() {
		this.ddd = ddd;
		this.numero = numero;
	}

	private String numero;


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
}
