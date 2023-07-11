package com.unla.grupo2OO2.entities;

import jakarta.persistence.Entity;

@Entity
public class DispositivoTemperatura extends Dispositivo{
	
	private int valorMinimo;
	private int valorMaximo;
	
	public DispositivoTemperatura (int id, String nombre, boolean activo, int valorMinimo, int valorMaximo) {
		super(id, nombre, activo);
		this.valorMaximo = valorMaximo;
		this.valorMinimo = valorMinimo;
		
	}
	public DispositivoTemperatura() {
		
	}
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
	

}
