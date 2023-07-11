package com.unla.grupo2OO2.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class SensorTemperaturaModel extends DispositivoModel {
	@Min (15)
	private int valorMinimo;
	@Max (35)
	private int valorMaximo;

	public int getValorMinimo() {
		return valorMinimo;
	}
	public void setValorMinimo(int valorMinimo) {
		this.valorMinimo = valorMinimo;
	}
	public int getValorMaximo() {
		return valorMaximo;
	}
	public void setValorMaximo(int valorMaximo) {
		this.valorMaximo = valorMaximo;
	}
	public SensorTemperaturaModel(int id, String nombre, boolean activo,int valorMinimo,int valorMaximo) {
		super(id, nombre, activo);
		this.valorMinimo = valorMinimo;
		this.valorMaximo = valorMaximo;
	}
	public SensorTemperaturaModel(String nombre, boolean activo,int valorMinimo,int valorMaximo) {
		super(nombre, activo);
		this.valorMinimo = valorMinimo;
		this.valorMaximo = valorMaximo;
	}
	public SensorTemperaturaModel() {
		// TODO Auto-generated constructor stub
	}
	
	

}
