package com.AppDirect.jBilling.product.productDetail;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@IdClass(StoreProductXref.class)
@Table(name = "price")
public class PriceEntity{
	
	@Id
	@Column(name = "sidentifier")
	private UUID store;
	@Id
	@Column(name = "pidentifier")
	private UUID product;
	private double price;
	@JsonIgnore
	private String notes;
	private Date created;
	
	public PriceEntity(){}	
	
	public PriceEntity(UUID store, UUID product, double price, String notes, Date created) {
		super();
		this.store = store;
		this.product = product;
		this.price = price;
		this.notes = notes;
		this.created = created;
	}
	
	public UUID getStore() {
		return store;
	}
	public void setStore(UUID store) {
		this.store = store;
	}
	public UUID getProduct() {
		return product;
	}
	public void setProduct(UUID product) {
		this.product = product;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@JsonIgnore
	public String getNotes() {
		return notes;
	}
	@JsonProperty
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	

}
