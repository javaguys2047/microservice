package com.javaguy.app.service.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="application")
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private String applicationName;
	private boolean status;
	
	@OneToOne
	@JoinColumn(name="group_id")
	private ApplicationGroup group;
	
	@OneToOne(mappedBy = "app")
	private ApplicationDetail appDetail;
	
	@OneToOne(mappedBy = "app")
	private ApplicationDetail doc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ApplicationGroup getGroup() {
		return group;
	}

	public void setGroup(ApplicationGroup group) {
		this.group = group;
	}
}
