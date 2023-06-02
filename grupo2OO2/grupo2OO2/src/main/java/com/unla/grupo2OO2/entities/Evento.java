package com.unla.grupo2OO2.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEvento;
	
	private String descripcion;
	
	private Dispositivo dispositivo;
	
	private LocalDate dia;
	
	private LocalTime horaDesde;
	
	private LocalTime horaHasta;
	
	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public Evento(int idEvento, String descripcion, Dispositivo dispositivo, LocalDate dia, LocalTime horaDesde,
			LocalTime horaHasta) {
		super();
		this.idEvento = idEvento;
		this.descripcion = descripcion;
		this.dispositivo = dispositivo;
		this.dia = dia;
		this.horaDesde = horaDesde;
		this.horaHasta = horaHasta;
	}
	
	

}
