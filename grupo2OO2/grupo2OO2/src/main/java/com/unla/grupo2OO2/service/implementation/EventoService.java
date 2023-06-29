package com.unla.grupo2OO2.service.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo2OO2.entities.Dispositivo;
import com.unla.grupo2OO2.entities.EstacionamientoInteligente;
import com.unla.grupo2OO2.entities.Evento;
import com.unla.grupo2OO2.entities.LucesInteligente;
import com.unla.grupo2OO2.repositories.IEventoRepository;
import com.unla.grupo2OO2.service.IEventoService;

@Service("eventoService")
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

	 @Override
	 public List<Evento> getEventosEstacionamiento() {
		 List<Evento> eventos = eventoRepository.findAll();
		 List<Evento> eventosEst = new ArrayList<>();
		 for(int i=0;i<eventos.size();i++) {
			 if(eventos.get(i).getDispositivo() instanceof EstacionamientoInteligente) {
				 eventosEst.add(eventos.get(i));
			 }
		 }
		 return eventosEst;
	 }
	 
	 @Override
	 public List<Evento> getEventosLuces() {
		 List<Evento> eventos = eventoRepository.findAll();
		 List<Evento> eventosEst = new ArrayList<>();
		 for(int i=0;i<eventos.size();i++) {
			 if(eventos.get(i).getDispositivo() instanceof LucesInteligente) {
				 eventosEst.add(eventos.get(i));
			 }
		 }
		 return eventosEst;
	 }
	 
	 @Override
	 public List<Evento> getByIdDispositivo(int id) {
		 return eventoRepository.findByIdDispositivo(id);
	 }

}
