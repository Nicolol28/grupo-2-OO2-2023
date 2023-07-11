package com.unla.grupo2OO2.service.implementation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.unla.grupo2OO2.entities.Dispositivo;
import com.unla.grupo2OO2.entities.Evento;
import com.unla.grupo2OO2.entities.LucesInteligente;
import com.unla.grupo2OO2.repositories.ILucesRepository;
import com.unla.grupo2OO2.service.ILucesService;

import lombok.AllArgsConstructor;


@Service("lucesService")
public class LucesService implements ILucesService{
	
	@Autowired
	@Qualifier("lucesRepository")
	private ILucesRepository lucesRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<LucesInteligente> getAll() {
		return lucesRepository.findAll();
	}

	@Override
	public LucesInteligente findById(int id) {
		return lucesRepository.findById(id);
	}

	
	@Override
	public LucesInteligente insertOrUpdate(LucesInteligente luces) {
		return lucesRepository.save(luces);
	}

	@Override
	public boolean remove(int id) {
		try {
			lucesRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
    public LucesInteligente agregarEvento(LucesInteligente dispositivo,LocalDate fecha,LocalTime horaDesde, String descripcion) {
       
	if (dispositivo != null) {			
       	LucesInteligente dispositivoExistente = lucesRepository.findById(dispositivo.getId());        
           if (dispositivoExistente != null) {
            	 List<Evento> eventos = dispositivoExistente.getEventos();
                  Evento evento = new Evento();               
               
                evento.setDescripcion(descripcion);
                evento.setDispositivo(dispositivo);
                evento.setDia(fecha);
                evento.setHoraDesde(horaDesde);
                
                
                eventos.add(evento);
                
               
                dispositivoExistente.setEventos(eventos);
               
               
                LucesInteligente dispositivoActualizado = lucesRepository.save((LucesInteligente)dispositivoExistente);
                return modelMapper.map(dispositivoActualizado, LucesInteligente.class);
            }
        }
     return null;
    }
	
}