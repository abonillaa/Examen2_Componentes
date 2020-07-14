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
	
	//TUTORIAL URL https://hellokoding.com/jpa-one-to-many-relationship-mapping-example-with-spring-boot-maven-and-mysql/
}
