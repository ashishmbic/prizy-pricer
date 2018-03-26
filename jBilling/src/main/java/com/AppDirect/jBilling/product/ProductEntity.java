package com.AppDirect.jBilling.product;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity {
	@Column
	@Id
	private UUID identifier;
	private String name;
	private double baseprice;
	private String description;
	private Date created;
	
	public ProductEntity(){}
	
	public ProductEntity(UUID identifier, String name, double baseprice, String description, Date created) {
		super();
		this.identifier = identifier;
		this.name = name;
		this.baseprice = baseprice;
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
	public double getBaseprice() {
		return baseprice;
	}
	public void setBaseprice(double baseprice) {
		this.baseprice = baseprice;
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
