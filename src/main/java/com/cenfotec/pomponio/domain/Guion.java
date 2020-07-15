package com.cenfotec.pomponio.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name="TBL_GUION")
public class Guion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre_obra")
	private String nombreObra;
	
	@Column(name="genero_obra")
	private String generoObra;
	
	@Column(name="idea_central")
	private String ideaCentral;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbl_guionista_id", referencedColumnName="id")
    private Guionista guionista;

	public Guion(int id, String nombreObra, String generoObra, String ideaCentral) {
		this.id = id;
		this.nombreObra = nombreObra;
		this.generoObra = generoObra;
		this.ideaCentral = ideaCentral;
	}
	

	public Guion(String nombreObra, String generoObra, String ideaCentral) {
		super();
		this.nombreObra = nombreObra;
		this.generoObra = generoObra;
		this.ideaCentral = ideaCentral;
	}
	
	public Guion(String nombreObra, String generoObra, String ideaCentral, int idGuionista) {
		super();
		this.nombreObra = nombreObra;
		this.generoObra = generoObra;
		this.ideaCentral = ideaCentral;
	}

	public Guion() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getNombreObra() {
		return nombreObra;
	}

	public void setNombreObra(String nombreObra) {
		this.nombreObra = nombreObra;
	}

	public String getGeneroObra() {
		return generoObra;
	}

	public void setGeneroObra(String generoObra) {
		this.generoObra = generoObra;
	}

	public String getIdeaCentral() {
		return ideaCentral;
	}

	public void setIdeaCentral(String ideaCentral) {
		this.ideaCentral = ideaCentral;
	}


	public Guionista getGuionista() {
		return guionista;
	}

	public void setGuionista(Guionista guionista) {
		this.guionista = guionista;
		guionista.getGuiones().add(this);
	}
}
