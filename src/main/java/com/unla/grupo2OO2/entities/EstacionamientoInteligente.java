package com.unla.grupo2OO2.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor

public class EstacionamientoInteligente extends Dispositivo{
	
	private int nroEstacionamiento;
	
	private boolean ocupado;
	
	private LocalDateTime horaDeOcupacion;
	
	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public EstacionamientoInteligente(int id, String nombre, boolean activo, int nroEstacionamiento, boolean ocupado, LocalDateTime horaDeOcupacion) {
		super(id, nombre, activo);
		this.nroEstacionamiento = nroEstacionamiento;
		this.ocupado = ocupado;
		this.horaDeOcupacion = horaDeOcupacion;
	}
	
	
}
