package com.unla.grupo2OO2.services;

import java.util.List;

import com.unla.grupo2OO2.entities.Dispositivo;
import com.unla.grupo2OO2.entities.EstacionamientoInteligente;

public interface IDispositivoService {
	public List<Dispositivo> getAll();

	public Dispositivo findById(int id);

	public Dispositivo insertOrUpdate(Dispositivo dispositivo);

	public boolean remove(int id);

}
