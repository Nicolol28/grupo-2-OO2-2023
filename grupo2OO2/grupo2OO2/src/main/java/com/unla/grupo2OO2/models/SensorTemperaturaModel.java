package com.unla.grupo2OO2.models;



public class SensorTemperaturaModel extends DispositivoModel {
	
	private double valorMinimo;
	private double valorMaximo;

	public double getValorMinimo() {
		return valorMinimo;
	}
	public void setValorMinimo(double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}
	public double getValorMaximo() {
		return valorMaximo;
	}
	public void setValorMaximo(double valorMaximo) {
		this.valorMaximo = valorMaximo;
	}
	public SensorTemperaturaModel(int id, String nombre, boolean activo,double valorMinimo, double valorMaximo) {
		super(id, nombre, activo);
		this.valorMinimo = valorMinimo;
		this.valorMaximo = valorMaximo;
	}
	
	

}
