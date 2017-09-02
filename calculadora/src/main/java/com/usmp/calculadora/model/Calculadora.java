package com.usmp.calculadora.model;

public class Calculadora {
	
	private Double operador1;
	private Double operador2;
	private String operando;
	private String resultado;
	
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public Double getOperador1() {
		return operador1;
	}
	public void setOperador1(Double operador1) {
		this.operador1 = operador1;
	}
	public Double getOperador2() {
		return operador2;
	}
	public void setOperador2(Double operador2) {
		this.operador2 = operador2;
	}
	public String getOperando() {
		return operando;
	}
	public void setOperando(String operando) {
		this.operando = operando;
	}

}
