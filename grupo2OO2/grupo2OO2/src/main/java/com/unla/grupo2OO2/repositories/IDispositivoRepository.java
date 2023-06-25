package com.unla.grupo2OO2.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.grupo2OO2.entities.Dispositivo;

@Repository("dispositivoRepositori")
public interface IDispositivoRepository extends JpaRepository<Dispositivo, Serializable>{
	public abstract Dispositivo findById(int id);

	public abstract Dispositivo findByNombre(String name);
}
