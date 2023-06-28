package com.unla.grupo2OO2.service.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo2OO2.entities.Dispositivo;
import com.unla.grupo2OO2.repositories.IDispositivoRepository;
import com.unla.grupo2OO2.service.IDispositivoService;

@Service
public class DispositivoService implements IDispositivoService{
	
	@Autowired
	@Qualifier("dispositivoRepository")
	private IDispositivoRepository dispositivoRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<Dispositivo> getAll() {
		return null;
	}

	@Override
	public Dispositivo findById(int id) {
		return dispositivoRepository.findById(id);
	}

	@Override
	public Dispositivo findByNombre(String name) {
		return dispositivoRepository.findByNombre(name);
	}

	@Override
	public Dispositivo insertOrUpdate(Dispositivo dispositivo) {
		return dispositivoRepository.save(dispositivo);
	}

	@Override
	public boolean remove(int id) {
		try {
			dispositivoRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

}
