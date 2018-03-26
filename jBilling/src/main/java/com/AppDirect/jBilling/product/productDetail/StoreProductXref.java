package com.AppDirect.jBilling.product.productDetail;

import java.io.Serializable;
import java.util.UUID;

/* This class is for the purpose of mapping candidate key in the Price table */


public class StoreProductXref implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	 UUID store;
	 UUID product;
	
	public boolean equals(StoreProductXref spx){
		return this.product.equals(spx.product) && this.store.equals(spx.store);
	}
	
	public int hashCode(){
		return ((int)this.product.toString().charAt(0)+ (int)this.store.toString().charAt(0))%10;
	}


}
