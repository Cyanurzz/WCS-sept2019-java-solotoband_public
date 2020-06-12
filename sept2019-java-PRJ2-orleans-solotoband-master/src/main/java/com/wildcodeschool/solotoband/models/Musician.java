package com.wildcodeschool.solotoband.models;


public class Musician {

	
	private int idMusician;
	private int idLead;
	private String lastName;
	private String firstName;
	private String pseudo;
	private String style;
	private String instrument;
	private String contactTel;
	private String contactMail;
	private String locate;
	private String img;
	private String pwd;


	public Musician() {
	}


	public int getIdMusician() {
		return idMusician;
	}


	public void setIdMusician(int idMusician) {
		this.idMusician = idMusician;
	}


	public int getIdLead() {
		return idLead;
	}


	public void setIdLead(int idLead) {
		this.idLead = idLead;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
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

	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}
	

	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
