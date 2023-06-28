package com.unla.grupo2OO2.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="user_role", uniqueConstraints=@UniqueConstraint(columnNames= {"role", "user_id"}))
public class UsuarioRol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="usuario_id", nullable=false)
	private Usuario usuario;

	@Column(name="role", nullable=false, length=100)
	private String role;

	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public UsuarioRol(int id, Usuario userio, String role) {
		this.id = id;
		this.usuario = usuario;
		this.role = role;
	}

}
