package com.unla.grupo2OO2.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

@Entity
@Getter @Setter @NoArgsConstructor
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
	
//Generear el degree tal 
	
//	@OneToMany(fetch=FetchType.LAZY, mappedBy="persona")
//	private Set<Degree> degrees = new HashSet<>();
	

	public Persona(int id, String nombre, String apellido, int dni) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.Apellido = apellido;
		this.dni = dni;
	}
	
	
	
		
	
	

}
