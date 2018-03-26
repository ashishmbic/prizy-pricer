package com.AppDirect.jBilling.store;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class StoreServiceIntegrationTest {
	
	@Autowired
	StoreService storeService;
	
	@Test
	public void addStoreTest(){

		StoreEntity pe = new StoreEntity();
		
		pe.setName("Flipkart");
		pe.setDescription("Online");
		
		
		StoreEntity npe = storeService.addStore(pe);
		
		assertNotNull(npe);
		assertNotNull(npe.getIdentifier());
		assertNotNull(npe.getCreated());
		assertEquals("Flipkart",npe.getName());
		assertEquals("Online",npe.getDescription());		
		
	
	}
	

}
