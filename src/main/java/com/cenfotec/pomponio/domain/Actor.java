package com.cenfotec.pomponio.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="tbl_actor")
public class Actor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="genero")
	private String genero;
	
	@Column(name="estatura")
	private String estatura;
	
	@Column(name="complexion")
	private String complexion;
	
	@Column(name="color_ojos")
	private String colorOjos;
	
	@Column(name="color_pelo")
	private String colorPelo;
	
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	public Actor(Long id, String nombre, String genero, String estatura, String complexion, String colorOjos,
			String colorPelo, Date fechaNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.estatura = estatura;
		this.complexion = complexion;
		this.colorOjos = colorOjos;
		this.colorPelo = colorPelo;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Actor(String nombre, String genero, String estatura, String complexion, String colorOjos, String colorPelo,
			Date fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.estatura = estatura;
		this.complexion = complexion;
		this.colorOjos = colorOjos;
		this.colorPelo = colorPelo;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Actor() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEstatura() {
		return estatura;
	}

	public void setEstatura(String estatura) {
		this.estatura = estatura;
	}

	public String getComplexion() {
		return complexion;
	}

	public void setComplexion(String complexion) {
		this.complexion = complexion;
	}

	public String getColorOjos() {
		return colorOjos;
	}

	public void setColorOjos(String colorOjos) {
		this.colorOjos = colorOjos;
	}

	public String getColorPelo() {
		return colorPelo;
	}

	public void setColorPelo(String colorPelo) {
		this.colorPelo = colorPelo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}
