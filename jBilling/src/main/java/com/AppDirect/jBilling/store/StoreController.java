package com.AppDirect.jBilling.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@RequestMapping(method=RequestMethod.POST,value="/store")
	public StoreEntity addStore(@RequestBody StoreEntity store ){
		StoreEntity response = storeService.addStore(store);
		return response;
	}
}
