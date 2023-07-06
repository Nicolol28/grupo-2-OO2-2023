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
import lombok.Setter;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.JOINED)

public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;

	private String Apellido;
	
	private int dni;

	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	public Persona(int id, String nombre, String apellido, int dni) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.Apellido = apellido;
		this.dni = dni;
	}

	public Persona() {
		
	}

}
