package com.unla.grupo2OO2.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.grupo2OO2.entities.Dispositivo;
import com.unla.grupo2OO2.entities.DispositivoTemperatura;

@Repository("dispositivoRepository")
public interface IDispositivoRepository extends JpaRepository<Dispositivo, Serializable> {

	public abstract Dispositivo findById(int id);


	// Todas los dispositivos por nombre
	@Query("FROM DispositivoTemperatura")
	public abstract List<DispositivoTemperatura> findBySensor();

	public abstract Dispositivo findByNombre(String name);
}
