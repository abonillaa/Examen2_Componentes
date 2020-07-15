package com.cenfotec.pomponio.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
@Table (name="tbl_guionista")
public class Guionista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;
	
	@OneToMany(
        mappedBy = "guionista",
        fetch = FetchType.LAZY
    )
    private Set<Guion> guiones;

	public Guionista(int id, String nombre, String direccion, Date fechaNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		guiones = new HashSet<>();
	}
	
	public Guionista(String nombre, String direccion, Date fechaNacimiento) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		
	}
	
	public Guionista() {
		guiones = new HashSet<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Set<Guion> getGuiones() {
		return guiones;
	}

	public void setGuiones(Set<Guion> guiones) {
		this.guiones = guiones;
		for (Guion guion : guiones) {
			guion.setGuionista(this);
        }
	}
	
}
