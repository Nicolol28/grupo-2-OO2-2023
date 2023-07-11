package com.unla.grupo2OO2.entities;
import java.time.LocalDateTime;



import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class EstacionamientoInteligente extends Dispositivo{
	
	
	private int nroEstacionamiento;
	
	private boolean ocupado;

	public EstacionamientoInteligente(int id, String nombre, boolean activo, int nroEstacionamiento, boolean ocupado, LocalDateTime horaDeOcupacion) {
		super(id, nombre, activo);
		this.nroEstacionamiento = nroEstacionamiento;
		this.ocupado = ocupado;
	}

	public EstacionamientoInteligente() {
		// TODO Auto-generated constructor stub
	}

	public boolean isActivo() {
		
		return false;
	}
	
}
