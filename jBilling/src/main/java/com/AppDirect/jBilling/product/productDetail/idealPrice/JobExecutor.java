package com.AppDirect.jBilling.product.productDetail.idealPrice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JobExecutor{
	
	private static ExecutorService service = Executors.newFixedThreadPool(16);
	private static ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(1);
	
	public void startExecution(Runnable r){
		service.execute(r);
	}
	
	//Job will start at 10th second and then after every 100 seconds
	public void startScheduledExecution(Runnable r){
		scheduledService.scheduleAtFixedRate(r, 10, 100, TimeUnit.SECONDS);
	}

}
