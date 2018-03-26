package com.AppDirect.jBilling.product.productDetail.idealPrice;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
	
	static ConcurrentHashMap<UUID,Double> cachedIdealPrice = new ConcurrentHashMap<UUID,Double>();

}
