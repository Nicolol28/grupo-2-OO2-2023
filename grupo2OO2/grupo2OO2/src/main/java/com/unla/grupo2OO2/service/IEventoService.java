package com.unla.grupo2OO2.service;

import java.util.List;

import com.unla.grupo2OO2.entities.Dispositivo;
import com.unla.grupo2OO2.entities.Evento;



public interface IEventoService {
	public List<Evento> getAll();

	//public List<Evento> getAllEntreFechas(LocalDateTime fechaDesde, LocalDateTime fechaHasta);
	public List<Evento> getAllPorDipositivo(Dispositivo dispositivo);
	
	public Evento buscar (int id);
	public Evento findByIdEvento(int id);

	public Evento insertOrUpdate(Evento evento);
	
	public List<Evento> getEventosLuces();
	public List<Evento> getEventosTemperatura();
	public List<Evento> getEventosEstacionamiento();
	public List<Evento> getByIdDispositivo(int id);
}
