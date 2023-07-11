package com.unla.grupo2OO2.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DispositivoModel {
	
	private int id;
	
	@Builder.Default
	private String nombre = "Sensor Temperatura";
	
	private boolean activo;
	
	private List<Eventomodel> eventos;

	
	public DispositivoModel(int id, String nombre, boolean activo) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setActivo(activo);
		this.eventos = new ArrayList<>();
	}
	
	public DispositivoModel(String nombre, boolean activo) {
		super();
		this.setNombre(nombre);
		this.setActivo(activo);
	}

	public DispositivoModel() {
		// TODO Auto-generated constructor stub
	}

	public List<Eventomodel> getEventos(){
		return this.eventos;
		
	}
	
	public void setEventos(List<Eventomodel> eventos) {
		this.eventos = eventos;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}


	
}
