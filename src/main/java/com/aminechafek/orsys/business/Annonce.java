package com.aminechafek.orsys.business;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Setter;

@Entity
@getter
@Setter
public class Annonce {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private LocalDateTime dateHeureCreation;
	
	private LocalDateTime dateHeureDebut;
	
	private LocalDateTime dateHeureFin;
	
	private String contenu;
	
	private String numeroCarte;
	
	@Digits(integer = 4, fraction = 0,message = "l'année doit contenir 4 chiffres")
	private int anneeExpiration;
	
	@Digits(integer = 2, fraction = 0,message = "la date doit contenir 4 chiffres")
	private byte moisExpiration;
	
	private String cryptogramme;
	
	@Positive
	private double montantRegleEnEuros;
	
	@ManyToOne
	private Client client;
	
	@ManyToOne
	private Diffusion diffusion;
	
	@OneToMany(mappedBy = "annonce")
	private List<TrancheHoraire> trancheHoraires;
	
	@ManyToMany
	private List<Zone>zones;
	
	public Annonce() {
		this.dateHeureCreation=LocalDateTime.now();
	}

	public Annonce(LocalDateTime dateHeureDebut, LocalDateTime dateHeureFin, String contenu, String numeroCarte,int anneeExpiration,byte moisExpiration,String cryptogramme, double montantRegleEnEuros, Client client) {
		super();
		this.dateHeureDebut = dateHeureDebut;
		this.dateHeureFin = dateHeureFin;
		this.contenu = contenu;
		this.numeroCarte = numeroCarte;
		this.anneeExpiration = anneeExpiration;
		this.moisExpiration = moisExpiration;
		this.cryptogramme = cryptogramme;
		this.montantRegleEnEuros = montantRegleEnEuros;
		this.client = client;
	}
	
	
}
