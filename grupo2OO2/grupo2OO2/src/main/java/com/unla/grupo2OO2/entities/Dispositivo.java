package com.unla.grupo2OO2.entities;

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

@Entity
@Getter @Setter @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Dispositivo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	private boolean activo;
	
	//@OneToMany(mappedBy = "dispositivo",  cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//private List<Medicion> mediciones = new ArrayList<>();

	@OneToMany(mappedBy = "dispositivo",  cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Evento> eventos = new ArrayList<>();
	
	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public Dispositivo(int id, String nombre, boolean activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.activo = activo;
	}
	
	public Dispositivo(String nombre, boolean activo) {
		super();
		this.nombre = nombre;
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Dispositivo [id=" + id + ", nombre=" + nombre + ", activo=" + activo + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
	
}
