package com.unla.grupo2OO2.service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.unla.grupo2OO2.entities.Dispositivo;
import com.unla.grupo2OO2.entities.EstacionamientoInteligente;


public interface IEstacionamientoService {
	public List<EstacionamientoInteligente> getAll();

	public EstacionamientoInteligente findById(int id);

	public EstacionamientoInteligente insertOrUpdate(EstacionamientoInteligente estacionamiento);

	public boolean remove(int id);

    
    public EstacionamientoInteligente agregarEvento(EstacionamientoInteligente dispositivo, LocalDate fecha, LocalTime horaDesde, LocalTime horaHasta, String descripcion);

}
