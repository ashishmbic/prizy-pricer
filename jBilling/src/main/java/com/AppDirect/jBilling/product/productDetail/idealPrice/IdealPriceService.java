package com.AppDirect.jBilling.product.productDetail.idealPrice;

import java.util.UUID;

public interface IdealPriceService {
	
	public double getIdealPrice(UUID id);	
	public Job startJob();
}
