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
	private String straatnaam;
	private int huisnummer;
	
	private String postcode;
	private String woonplaats;
	private String telefoonnummer;
	private String emailadres;
	private String opleidingsniveau;
	private String beschikbaarheid;
	
	
	private String[] karaktereigenschappen;
	private String[] vaardigheden; 
	private String[] gelinkteVacatures;
	
	
	public String getOpleidingsniveau() {
		return opleidingsniveau;
	}
	public void setOpleidingsniveau(String opleidingsniveau) {
		this.opleidingsniveau = opleidingsniveau;
	}
	public String getBeschikbaarheid() {
		return beschikbaarheid;
	}
	public void setBeschikbaarheid(String beschikbaarheid) {
		this.beschikbaarheid = beschikbaarheid;
	}
	public String[] getKaraktereigenschappen() {
		return karaktereigenschappen;
	}
	public void setKaraktereigenschappen(String[] karaktereigenschappen) {
		this.karaktereigenschappen = karaktereigenschappen;
	}
	public String[] getVaardigheden() {
		return vaardigheden;
	}
	public void setVaardigheden(String[] vaardigheden) {
		this.vaardigheden = vaardigheden;
	}
	
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
	
	public String[] getGelinkteVacatures() {
		return gelinkteVacatures;
	}
	public void setGelinkteVacatures(String[] gelinkteVacatures) {
		this.gelinkteVacatures = gelinkteVacatures;
	}
	public String getStraatnaam() {
		return straatnaam;
	}
	public void setStraatnaam(String straatnaam) {
		this.straatnaam = straatnaam;
	}
	public int getHuisnummer() {
		return huisnummer;
	}
	public void setHuisnummer(int huisnummer) {
		this.huisnummer = huisnummer;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	
}
