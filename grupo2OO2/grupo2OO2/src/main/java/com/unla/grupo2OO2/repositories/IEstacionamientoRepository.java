package com.unla.grupo2OO2.repositories;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.grupo2OO2.entities.EstacionamientoInteligente;


@Repository("estacionamientoRepository")
public interface IEstacionamientoRepository extends JpaRepository<EstacionamientoInteligente, Serializable>{
	public abstract EstacionamientoInteligente findById(int id);
	
	

	// Todas los estacionamientos que tengan activo true
	@Query("SELECT e FROM EstacionamientoInteligente e WHERE e.activo = :activo")
	public abstract List<EstacionamientoInteligente> findByActivo(boolean activo);
}
