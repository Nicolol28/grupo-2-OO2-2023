package com.unla.grupo2OO2.entities;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class LucesInteligente extends Dispositivo{
	
	
	private int nroAula;
	
	private boolean ocupada;

	public LucesInteligente(int id, String nombre, boolean activo, int nroAula, boolean ocupada) {
		super(id, nombre, activo);
		this.nroAula = nroAula;
		this.ocupada = ocupada;
	}
	
}
