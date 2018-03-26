package com.AppDirect.jBilling.product.productDetail.idealPrice;

import java.util.List;

public interface IdealPriceStrategy {
	
	public double calculateIdealPrice(List<Double> prices);

}
