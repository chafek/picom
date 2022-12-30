package com.aminechafek.orsys.business;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

public class Zone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	private String nom;
	
	@ManyToMany(mappedBy = "zones")
	private List<Annonce> annonces;
	
	@OneToOne
	private Arret arret;
}
