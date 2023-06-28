package com.unla.grupo2OO2.models;

import java.time.LocalDateTime;



public class EstacionamientoModel extends DispositivoModel{
	
	private int nroEstacionamiento;
	
	private boolean ocupado;
	
	private LocalDateTime horaDeOcupacion;

	public EstacionamientoModel(int id, String nombre, boolean activo, int nroEstacionamiento, boolean ocupado, LocalDateTime horaDeOcupacion) {
		super(id, nombre, activo);
		this.setNroEstacionamiento(nroEstacionamiento);
		this.setOcupado(ocupado);
		this.setHoraDeOcupacion(horaDeOcupacion);
	}

	public int getNroEstacionamiento() {
		return nroEstacionamiento;
	}

	public void setNroEstacionamiento(int nroEstacionamiento) {
		this.nroEstacionamiento = nroEstacionamiento;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public LocalDateTime getHoraDeOcupacion() {
		return horaDeOcupacion;
	}

	public void setHoraDeOcupacion(LocalDateTime horaDeOcupacion) {
		this.horaDeOcupacion = horaDeOcupacion;
	}


}
