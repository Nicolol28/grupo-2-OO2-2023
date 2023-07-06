package com.unla.grupo2OO2.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class DispositivoTemperatura extends Dispositivo{
	
	private double valorMinimo;
	private double valorMaximo;
	
	public DispositivoTemperatura (int id, String nombre, boolean activo, double valorMinimo, double valorMaximo) {
		super(id, nombre, activo);
		this.valorMaximo = valorMaximo;
		this.valorMinimo = valorMinimo;
		
	}

}
