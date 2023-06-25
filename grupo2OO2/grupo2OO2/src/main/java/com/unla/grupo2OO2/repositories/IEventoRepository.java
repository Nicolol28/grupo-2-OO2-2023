package com.unla.grupo2OO2.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo2OO2.entities.Dispositivo;

import com.unla.grupo2OO2.entities.Evento;

@Repository("eventoRepository")
public interface IEventoRepository extends  JpaRepository<Evento, Serializable>{
	
	
	public Evento findByIdEvento(int id);
	
	public abstract List<Evento> findByDia(LocalDate fechaHora);
	public abstract List<Evento> findByHoraHasta(LocalTime horaHasta);
	public abstract List<Evento> findByHoraDesde(LocalTime HoraDesde);



	//public abstract List<Evento> findByfechaHoraBetween(LocalDateTime fechaHoraDesde, LocalDateTime fechaHoraHasta);
	
	public abstract List<Evento> findByDispositivo(Dispositivo dispositivo);
}
