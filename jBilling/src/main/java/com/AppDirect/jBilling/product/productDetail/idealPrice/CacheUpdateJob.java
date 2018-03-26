package com.AppDirect.jBilling.product.productDetail.idealPrice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.AppDirect.jBilling.product.productDetail.PriceRepository;

public class CacheUpdateJob implements Runnable {
	
	private UUID pid;
	
	@Autowired
	PriceRepository priceRepository;
	
	
	@Autowired
	IdealPriceStrategy idealPriceStrategy;
	
	public CacheUpdateJob(UUID pid){
		this.pid = pid;	
	}
	
	public void run(){		
		List<Double> temp = new ArrayList<Double>();
		temp = priceRepository.getAllPricesByProduct(pid);
		List<Double> prices = new LinkedList<Double>();
		for(Number i : temp){
			prices.add(i.doubleValue());
		}
		Cache.cachedIdealPrice.put(this.pid,idealPriceStrategy.calculateIdealPrice(prices));
		
	}

}
