package com.unla.grupo2OO2.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.unla.grupo2OO2.entities.Dispositivo;
import com.unla.grupo2OO2.entities.Evento;


public interface IEventoService {
	public List<Evento> getAll();
	
	
	public Evento buscar (int id);
	public Evento findByIdEvento(int id);

	Evento insertOrUpdate(Evento evento);
	
	public List<Evento> getEventosEstacionamiento();
	public List<Evento> getEventosLuces();
	public List<Evento> getByIdDispositivo(int id);
}
