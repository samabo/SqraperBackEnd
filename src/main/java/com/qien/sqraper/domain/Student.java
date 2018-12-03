package com.qien.sqraper.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id		
	@GeneratedValue(strategy = GenerationType.AUTO)		
	private long id;
	
	private String voornaam;
	private String voorvoegsel;
	private String achternaam;
	private String woonplaats;
	private String telefoonnummer;
	private String emailadres;
	private String [] keywords;
	private String [] gelinkteVacatures;
	
	
	public long getId() {
		return id;
	}
	public String getVoornaam() {
		return voornaam;
	}
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	public String getVoorvoegsel() {
		return voorvoegsel;
	}
	public void setVoorvoegsel(String voorvoegsel) {
		this.voorvoegsel = voorvoegsel;
	}
	public String getAchternaam() {
		return achternaam;
	}
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	public String getWoonplaats() {
		return woonplaats;
	}
	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}
	public String getTelefoonnummer() {
		return telefoonnummer;
	}
	public void setTelefoonnummer(String telefoonnummer) {
		this.telefoonnummer = telefoonnummer;
	}
	public String getEmailadres() {
		return emailadres;
	}
	public void setEmailadres(String emailadres) {
		this.emailadres = emailadres;
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
