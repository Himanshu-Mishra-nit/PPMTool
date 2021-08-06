package io.agileintelligence.ppmtool.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class Project implements Serializable {

	private static final long serialVersionUID = -1866545787029275672L;


	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name="name")
	private String name;

	@Column(name="identifier")
	private String identifier;
	
	@Column(name="description")
	private String description;
	
	@Column(name="start_date")
	private Date start_date;
	
	@Column(name="end_date")
	private Date end_date;
	
	@Column(name="created_At")
	private Date created_At;
	
	@Column(name="updated_At")
	private Date updated_At;
	

	public Project() {
		
	}

	@PrePersist
	protected void onCreate(){
		this.created_At = new Date();
	}

	@PreUpdate
	protected void onUpdate(){
		this.updated_At = new Date();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	public Date getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}

	
	
}
