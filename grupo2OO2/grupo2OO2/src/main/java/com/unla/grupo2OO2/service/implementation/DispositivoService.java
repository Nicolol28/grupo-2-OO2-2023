package com.unla.grupo2OO2.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.grupo2OO2.entities.Dispositivo;
import com.unla.grupo2OO2.entities.DispositivoTemperatura;
import com.unla.grupo2OO2.models.SensorTemperaturaModel;
import com.unla.grupo2OO2.repositories.IDispositivoRepository;
import com.unla.grupo2OO2.service.IDispositivoService;

@Service("dispositivoService")
public class DispositivoService implements IDispositivoService{
	
	@Autowired
	@Qualifier("dispositivoRepository")
	private IDispositivoRepository dispositivoRepository;

	private ModelMapper modelMapper = new ModelMapper();
	
	
	
	@Override
	public List<SensorTemperaturaModel> finBySensor() {
		List<SensorTemperaturaModel> sensores = new ArrayList<>();
		for (DispositivoTemperatura sensor : dispositivoRepository.findBySensor()) {
			sensores.add(modelMapper.map(sensor, SensorTemperaturaModel.class));
		}
		return sensores;
	}

	@Override
	public List<Dispositivo> getAll() {
		return dispositivoRepository.findAll();
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
			Dispositivo dispositivo = dispositivoRepository.findById(id);
			dispositivo.setActivo(false);
			dispositivoRepository.save(dispositivo);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
		

}
