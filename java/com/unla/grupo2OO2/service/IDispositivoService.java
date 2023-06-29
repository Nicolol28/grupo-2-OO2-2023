package com.unla.grupo2OO2.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.unla.grupo2OO2.entities.Dispositivo;


public interface IDispositivoService {
	public List<Dispositivo> getAll();

	public Dispositivo findById(int id);

	public Dispositivo findByNombre(String name);

	public Dispositivo insertOrUpdate(Dispositivo dispositivo);

	public boolean remove(int id);
}
