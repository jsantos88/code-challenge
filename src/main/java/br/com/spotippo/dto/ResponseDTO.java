package br.com.spotippo.dto;

import java.util.List;

import br.com.spotippo.model.PropertyEntity;

public class ResponseDTO {
	
	private int foundProperties;
	
	private List<PropertyEntity> properties;
	
	public int getFoundProperties() {
		return foundProperties;
	}

	public void setFoundProperties(int foundProperties) {
		this.foundProperties = foundProperties;
	}

	public List<PropertyEntity> getProperties() {
		return properties;
	}

	public void setProperties(List<PropertyEntity> properties) {
		this.properties = properties;
	}

}
