package com.unla.grupo2OO2.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class DispositivoModel {
	
	private int id;
	
	private String nombre;
	
	private boolean activo;

	
	public DispositivoModel(int id, String nombre, boolean activo) {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setActivo(activo);
	}
	
	public DispositivoModel(String nombre, boolean activo) {
		super();
		this.setNombre(nombre);
		this.setActivo(activo);
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
