package com.unla.grupo2OO2.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Administrador extends Persona {
	
	private int nroAdministrador;

}
