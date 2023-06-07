package com.unla.grupo2OO2.services.implementation;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.unla.grupo2OO2.entities.Dispositivo;
import com.unla.grupo2OO2.repositories.IDispositivoRepository;
import com.unla.grupo2OO2.services.IDispositivoService;

@Service("dispositivoService")
public class DispositivoServices implements IDispositivoService{
	
	@Autowired
	@Qualifier("dispositivoRepository")
	private IDispositivoRepository dispositivoRepository;

	@Override
	public List<Dispositivo> getAll() {
		return dispositivoRepository.findAll();
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

	@Override
	public Dispositivo findById(int id) {
		return dispositivoRepository.findById(id);
	}

}
