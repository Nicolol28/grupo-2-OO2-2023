package com.unla.grupo2OO2.models;




public class LucesModel extends DispositivoModel{
	
	private int nroAula;
	
	private boolean ocupada;

	public LucesModel(int id, String nombre, boolean activo, int nroAula, boolean ocupada) {
		super(id, nombre, activo);
		this.setNroAula(nroAula);
		this.setOcupada(ocupada);
	}

	public int getNroAula() {
		return nroAula;
	}

	public void setNroAula(int nroAula) {
		this.nroAula = nroAula;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	

	
	


}
