package com.unla.grupo2OO2.service;

import java.util.List;

import com.unla.grupo2OO2.entities.Dispositivo;
import com.unla.grupo2OO2.models.SensorTemperaturaModel;


public interface IDispositivoService {
	public List<Dispositivo> getAll();

	public Dispositivo findById(int id);
	
	public List<SensorTemperaturaModel> finBySensor();
	
	public Dispositivo findByNombre(String name);

	public Dispositivo insertOrUpdate(Dispositivo dispositivo);

	public boolean remove(int id);
}
