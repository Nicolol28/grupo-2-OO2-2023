package com.unla.grupo2OO2.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.unla.grupo2OO2.entities.Dispositivo;
import com.unla.grupo2OO2.entities.Evento;


public interface IEventoService {
	public List<Evento> getAll();

	//public List<Evento> getAllEntreFechas(LocalDateTime fechaDesde, LocalDateTime fechaHasta);
	public List<Evento> getAllPorDipositivo(Dispositivo dispositivo);
	
	public Evento buscar (int id);
	public Evento findByIdEvento(int id);

	Evento insertOrUpdate(Evento evento);
}
