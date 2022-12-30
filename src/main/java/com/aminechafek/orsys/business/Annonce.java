package com.aminechafek.orsys.business;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;

@Entity
@Data
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
	
	
	private Client client;
	
	private Diffusion diffusion;
	
	private List<TrancheHoraire> trancheHoraires;
	
	private List<Zone>zones;
}
