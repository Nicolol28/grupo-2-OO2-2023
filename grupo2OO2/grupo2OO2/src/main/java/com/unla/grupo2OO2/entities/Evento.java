package com.unla.grupo2OO2.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEvento;
	
	private String descripcion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	// normalmente nullable es igual a false, en este caso se deja como true porque el ejemplo es simple
	@JoinColumn(name="dispositivo_id", nullable=false)
	private Dispositivo dispositivo;
	
	private LocalDate dia;
	
	private LocalTime horaDesde;
	
	
	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public LocalTime getHoraDesde() {
		return horaDesde;
	}

	public void setHoraDesde(LocalTime horaDesde) {
		this.horaDesde = horaDesde;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Evento(String descripcion, Dispositivo dispositivo, LocalDate dia, LocalTime horaDesde) {
		super();
		this.descripcion = descripcion;
		this.dispositivo = dispositivo;
		this.dia = dia;
		this.horaDesde = horaDesde;
	}

	public Evento() {
		// TODO Auto-generated constructor stub
	}
	
}
