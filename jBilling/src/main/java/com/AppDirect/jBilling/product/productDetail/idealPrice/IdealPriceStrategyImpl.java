package com.AppDirect.jBilling.product.productDetail.idealPrice;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class IdealPriceStrategyImpl implements IdealPriceStrategy {
	
public double calculateIdealPrice(List<Double> prices){
		
		Collections.sort(prices);
		
		double sum = 0.0;
		
		for(int i = 2; i<prices.size()-2;i++){
			
			sum = sum + prices.get(i);
		}
		
		double avg = 0.0;
		
		if(prices.size()!=4){
		avg = sum / (prices.size()-4);
		}
		double idealPrice = avg + (avg*0.20);
		
		return idealPrice;
	}

}
