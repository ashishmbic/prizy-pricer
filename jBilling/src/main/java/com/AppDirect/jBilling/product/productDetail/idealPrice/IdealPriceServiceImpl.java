package com.AppDirect.jBilling.product.productDetail.idealPrice;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdealPriceServiceImpl implements IdealPriceService{	
	
	@Autowired
	IdealPriceCalculator idealPriceCalculator;

	public Job startJob(){
		
		Job job = new Job();
		job.setJob(this.idealPriceCalculator.updatePriceCache());
		job.setStarted(new Date());
		return job;
}
	//If key Absent from the cache, return 0.
	public double getIdealPrice(UUID id){
		
		return Cache.cachedIdealPrice.getOrDefault(id,0.0);		
		
	}	

}