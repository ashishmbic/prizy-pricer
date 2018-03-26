package com.AppDirect.jBilling.product.productDetail.idealPrice;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.AppDirect.jBilling.product.productDetail.PriceRepository;

@Service
public class IdealPriceCalculatorImpl implements IdealPriceCalculator{
	
	@Autowired
	PriceRepository priceRepository;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	public String updatePriceCache(){
		List<UUID> products = new ArrayList<UUID>();
		products = priceRepository.getAllProducts();
		for(UUID product: products){
			CacheUpdateJob cuj = new CacheUpdateJob(product);
			applicationContext.getAutowireCapableBeanFactory().autowireBean(cuj);
			new JobExecutor().startExecution(cuj);
		}
		
		/*
		Returns the current executing method, this needs to be modified if additional methods are added.
		*/
		Class<IdealPriceCalculator> idealPriceCalculator = IdealPriceCalculator.class;
		Method method = idealPriceCalculator.getMethods()[0];		
		return method.toString();	
	}
	
	{
		Runnable r = new Runnable(){
			public void run(){
				updatePriceCache();
			}
		};
		new JobExecutor().startScheduledExecution(r);
		
	}
	
	

}
