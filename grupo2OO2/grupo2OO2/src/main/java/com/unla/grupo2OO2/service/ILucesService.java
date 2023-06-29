package com.unla.grupo2OO2.service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.unla.grupo2OO2.entities.LucesInteligente;



public interface ILucesService {
	
	public List<LucesInteligente> getAll();

	public LucesInteligente findById(int id);

	public LucesInteligente insertOrUpdate(LucesInteligente luces);

	public boolean remove(int id);

    
    public LucesInteligente agregarEvento(LucesInteligente dispositivo, LocalDate fecha, LocalTime horaDesde, LocalTime horaHasta, String descripcion);

}
