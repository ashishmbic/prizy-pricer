package com.AppDirect.jBilling.store;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "store")
public class StoreEntity {
	@Id
	private UUID identifier;
	private String name;
	private String description;
	private Date created;	
	
	public StoreEntity(){}
	
	public StoreEntity(UUID identifier, String name, String description, Date created) {
		super();
		this.identifier = identifier;
		this.name = name;
		this.description = description;
		this.created = created;
	}
	
	public UUID getIdentifier() {
		return identifier;
	}
	public void setIdentifier(UUID identifier) {
		this.identifier = identifier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}	

}
