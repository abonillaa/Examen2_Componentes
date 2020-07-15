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
	@Column(name="ID")
	private int id;
	
	@Column(name="NOMBRE_OBRA")
	private String nombreObra;
	
	@Column(name="GENERO_OBRA")
	private String generoObra;
	
	@Column(name="IDEA_CENTRAL")
	private String ideaCentral;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TBL_GUIONISTA_ID", referencedColumnName = "ID")
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
