package com.unla.grupo2OO2.services.implementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.unla.grupo2OO2.entities.Dispositivo;
import com.unla.grupo2OO2.entities.Evento;
import com.unla.grupo2OO2.repositories.IEventoRepository;
import com.unla.grupo2OO2.service.IEventoService;

public class EventoService implements IEventoService{
	
	@Autowired
	@Qualifier("eventoRepository")
	private IEventoRepository eventoRepository;

	@Override
	public List<Evento> getAll() {
		// TODO Auto-generated method stub
		return eventoRepository.findAll();
	}

	/*@Override
	public List<Evento> getAllEntreFechas(LocalDateTime fechaDesde, LocalDateTime fechaHasta) {
		// TODO Auto-generated method stub
		return eventoRepository.findByfechaHoraBetween(fechaDesde, fechaHasta);
	}*/

	@Override
	public List<Evento> getAllPorDipositivo(Dispositivo dispositivo) {
		// TODO Auto-generated method stub
		return eventoRepository.findByDispositivo(dispositivo);
	}

	@Override
	public Evento buscar(int id) {
		// TODO Auto-generated method stub
		return eventoRepository.findById(id).orElse(null);
	}

	@Override
	public Evento insertOrUpdate(Evento evento) {
		// TODO Auto-generated method stub
		return ((IEventoService) eventoRepository).insertOrUpdate(evento);
	}
	
	

	@Override
	public Evento findByIdEvento(int id) {
		// TODO Auto-generated method stub
		return eventoRepository.findByIdEvento(id);
	}



}
