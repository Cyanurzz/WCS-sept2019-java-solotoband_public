package com.wildcodeschool.solotoband.models;

public class Band {

	private int idGroup;
	private int idLead;
	private String name; 
	private String style;
	private String contactTel;
	private String contactMail;
	private String locate;
	private String description;
	private String img;
	

	public Band() {
	}

	
	public int getIdGroup() {
		return idGroup;
	}

	
	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	
	public int getIdLead() {
		return idLead;
	}

	
	public void setIdLead(int idLead) {
		this.idLead = idLead;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public String getStyle() {
		return style;
	}

	
	public void setStyle(String style) {
		this.style = style;
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

	
	public String getDescription() {
		return description;
	}

	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}
}
