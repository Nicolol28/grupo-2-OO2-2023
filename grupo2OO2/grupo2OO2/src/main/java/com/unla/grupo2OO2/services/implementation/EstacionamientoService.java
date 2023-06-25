package com.unla.grupo2OO2.services.implementation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.unla.grupo2OO2.entities.Dispositivo;
import com.unla.grupo2OO2.entities.EstacionamientoInteligente;
import com.unla.grupo2OO2.entities.Evento;
import com.unla.grupo2OO2.repositories.IEstacionamientoRepository;
import com.unla.grupo2OO2.service.IEstacionamientoService;


@Service("estacionamientoService")
public abstract class EstacionamientoService implements IEstacionamientoService{
	
	@Autowired
	@Qualifier("estacionamientoRepository")
	private IEstacionamientoRepository estacionamientoRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<EstacionamientoInteligente> getAll() {
		return estacionamientoRepository.findAll();
	}

	@Override
	public EstacionamientoInteligente findById(int id) {
		return estacionamientoRepository.findById(id);
	}

	
	@Override
	public EstacionamientoInteligente insertOrUpdate(EstacionamientoInteligente estacionamiento) {
		return estacionamientoRepository.save(estacionamiento);
	}

	@Override
	public boolean remove(int id) {
		try {
			estacionamientoRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}


	@Override
    public EstacionamientoInteligente agregarEvento(EstacionamientoInteligente dispositivo,LocalDate fecha,LocalTime horaDesde, LocalTime horaHasta, String descripcion) {
        //compruevo que el dispositivo no sea null
		if (dispositivo != null) {
			//ya que no lo es lo busco por id
        	EstacionamientoInteligente dispositivoExistente = estacionamientoRepository.findById(dispositivo.getId());
        	//compruebo que este cargado
            if (dispositivoExistente != null) {
            	//creo una lista de eventos y la igualo a la que viene de dispositivo
                List<Evento> eventos = dispositivoExistente.getEventos();
                
                //creo un evento para cambiar las variables
                Evento evento = new Evento();
                
                //cambio las variables
                evento.setDescripcion(descripcion);
                evento.setDispositivo(dispositivo);
                evento.setDia(fecha);
                evento.setHoraDesde(horaDesde);
                evento.setHoraHasta(horaHasta);
                
                //agrego el evento a la lista
                eventos.add(evento);
                
                //seteo la lista
                dispositivoExistente.setEventos(eventos);
               
                //guardo los cambios en la bd
                EstacionamientoInteligente dispositivoActualizado = estacionamientoRepository.save((EstacionamientoInteligente)dispositivoExistente);
                return modelMapper.map(dispositivoActualizado, EstacionamientoInteligente.class);
            }
        }
     return null;
    }
	
}
