package com.wildcodeschool.solotoband.models;

public class WantAd {
	

	private int idAnnonce;
	private int idMusician;
	private int idLead;
	private Integer idGroup;
	private String title; 
	private String date;
	private String description;
	private String style;
	private String instrument;
	private String contactTel;
	private String contactMail;
	private String locate;
	private String musicianLastName;
	private String musicianFirstName;
	private String musicianImg;
	private String bandName; 
	
	

	public WantAd() {
		
	}

	
	public int getIdAnnonce() {
		return idAnnonce;
	}

	
	public void setIdAnnonce(int idAnnonce) {
		this.idAnnonce = idAnnonce;
	}

	
	public int getIdLead() {
		return idLead;
	}

	
	public void setIdLead(int idLead) {
		this.idLead = idLead;
	}


	public Integer getIdGroup() {

		return idGroup;
	}

	
	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	
	public String getTitle() {
		return title;
	}

	
	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getDate() {
		return date;
	}

	
	public void setDate(String date) {
		this.date = date;
	}

	
	public String getDescription() {
		return description;
	}

	
	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getStyle() {
		return style;
	}

	
	public void setStyle(String style) {
		this.style = style;
	}

	
	public String getInstrument() {
		return instrument;
	}

	
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	
	public String getContactTel() {
		return contactTel;
	}

	
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	
	public String getContactMail() {
		return contactMail;
	}

	
	public void setContactMail(String contactMail) {
		this.contactMail = contactMail;
	}

	
	public String getLocate() {
		return locate;
	}

	
	public void setLocate(String locate) {
		this.locate = locate;
	}

	public int getIdMusician() {
		return idMusician;
	}

	public void setIdMusician(int idMusician) {
		this.idMusician = idMusician;
	}

	public String getMusicianLastName() {
		return musicianLastName;
	}

	public void setMusicianLastName(String musicianLastName) {
		this.musicianLastName = musicianLastName;
	}

	public String getMusicianFirstName() {
		return musicianFirstName;
	}

	public void setMusicianFirstName(String musicianFirstName) {
		this.musicianFirstName = musicianFirstName;
	}

	public String getMusicianImg() {
		return musicianImg;
	}

	public void setMusicianImg(String musicianImg) {
		this.musicianImg = musicianImg;
	}

	public String getBandName() {
		return bandName;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
	}
	

}	
