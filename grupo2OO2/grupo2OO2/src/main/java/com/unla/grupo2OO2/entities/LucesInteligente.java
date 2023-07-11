package com.unla.grupo2OO2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class LucesInteligente extends Dispositivo{
	
	
	private int nroAula;
	
	private boolean ocupada;

	public LucesInteligente(int id, String nombre, boolean activo, int nroAula, boolean ocupada) {
		super(id, nombre, activo);
		this.nroAula = nroAula;
		this.ocupada = ocupada;
	}
	public LucesInteligente() {
		
	}
	public int getNroAula() {
		return nroAula;
	}
	public void setNroAula(int nroAula) {
		this.nroAula = nroAula;
	}
	public boolean isOcupada() {
		return ocupada;
	}
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	
	
	
}
