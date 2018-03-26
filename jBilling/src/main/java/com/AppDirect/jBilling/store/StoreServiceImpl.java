package com.AppDirect.jBilling.store;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService{
	
	@Autowired
	private StoreRepository storeRepository;
	
	public StoreEntity addStore(StoreEntity store){		
		store.setCreated(new Date());
		store.setIdentifier(UUID.randomUUID());
		storeRepository.save(store);
		return store;
	}

}
