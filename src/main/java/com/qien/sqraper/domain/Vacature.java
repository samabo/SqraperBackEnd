package com.qien.sqraper.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vacature {

	@Id		
	@GeneratedValue(strategy = GenerationType.AUTO)		
	private long id;
	
	private LocalDate plaatsingsdatum;
	private String titel;
	private String omschrijving;
	private String plaats;
	private String [] keywords;
	private String [] gelinkteVacatures;
	
	
	public long getId() {
		return id;
	}
	
	public LocalDate getPlaatsingsdatum() {
		return plaatsingsdatum;
	}
	public void setPlaatsingsdatum(LocalDate plaatsingsdatum) {
		this.plaatsingsdatum = plaatsingsdatum;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getOmschrijving() {
		return omschrijving;
	}
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
	public String getPlaats() {
		return plaats;
	}
	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}
	public String[] getKeywords() {
		return keywords;
	}
	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}
	public String[] getGelinkteVacatures() {
		return gelinkteVacatures;
	}
	public void setGelinkteVacatures(String[] gelinkteVacatures) {
		this.gelinkteVacatures = gelinkteVacatures;
	}
	
	
	
}
