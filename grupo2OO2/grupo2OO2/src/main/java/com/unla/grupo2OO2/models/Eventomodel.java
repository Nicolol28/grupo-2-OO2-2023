package com.unla.grupo2OO2.models;

import java.time.LocalDate;
import java.time.LocalTime;

import com.unla.grupo2OO2.entities.Dispositivo;

public class Eventomodel {
	private int idEvento;
	private String descripcion;
	private Dispositivo dispositivo;
	private LocalDate dia;

	private LocalTime horaDesde;
	
	public Eventomodel(int idEvento, String descripcion, Dispositivo dispositivo, LocalDate dia, LocalTime horaDesde) {
		super();
		this.idEvento = idEvento;
		this.descripcion = descripcion;
		this.dispositivo = dispositivo;
		this.dia = dia;
		this.horaDesde = horaDesde;
		
	}

	public Eventomodel() {
		
	}

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
	

}
