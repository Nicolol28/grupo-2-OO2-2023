package com.unla.grupo2OO2.repositories;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.unla.grupo2OO2.entities.LucesInteligente;


@Repository("lucesRepository")
public interface ILucesRepository extends JpaRepository<LucesInteligente, Serializable>{
	public abstract LucesInteligente findById(int id);
	
	

	@Query("SELECT l FROM LucesInteligente l WHERE l.activo = :activo")
	public abstract List<LucesInteligente> findByActivo(boolean activo);
}
