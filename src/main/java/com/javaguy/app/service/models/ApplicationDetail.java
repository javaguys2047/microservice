package com.javaguy.app.service.models;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="application_detail")
public class ApplicationDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private String keepaliveURL;
	@ElementCollection
	private Collection<Integer> httpPorts;
	@ElementCollection
	private Collection<Integer> jmxPorts;
	private Integer pingFrequency;
	@ElementCollection
	private Map<String,String> jmxCredentials;
	
	
	@OneToOne
	@JoinColumn(name = "app_id")
	private Application app;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKeepaliveURL() {
		return keepaliveURL;
	}
	public void setKeepaliveURL(String keepaliveURL) {
		this.keepaliveURL = keepaliveURL;
	}
	public Collection<Integer> getHttpPorts() {
		return httpPorts;
	}
	public void setHttpPorts(List<Integer> httpPorts) {
		this.httpPorts = httpPorts;
	}
	public Collection<Integer> getJmxPorts() {
		return jmxPorts;
	}
	public void setJmxPorts(List<Integer> jmxPorts) {
		this.jmxPorts = jmxPorts;
	}
	public Integer getPingFrequency() {
		return pingFrequency;
	}
	public void setPingFrequency(Integer pingFrequency) {
		this.pingFrequency = pingFrequency;
	}
	public Map<String, String> getJmxCredentials() {
		return jmxCredentials;
	}
	public void setJmxCredentials(Map<String, String> jmxCredentials) {
		this.jmxCredentials = jmxCredentials;
	}
}
