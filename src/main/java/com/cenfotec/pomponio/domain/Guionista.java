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
@Table (name="TBL_GUIONISTA")
public class Guionista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="DIRECCION")
	private String direccion;
	
	@Column(name="FECHA_NACIMIENTO")
	private Date fechaNacimiento;
	
	@OneToMany(
        mappedBy = "guionista",
        cascade = CascadeType.PERSIST,
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
