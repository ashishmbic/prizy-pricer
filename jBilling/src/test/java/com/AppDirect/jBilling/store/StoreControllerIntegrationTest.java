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
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StoreControllerIntegrationTest {
	
	@Autowired
	StoreController storeController;
	
	@Test
	public void addStoreTest(){
		StoreEntity storeEntity = new StoreEntity();
		storeEntity.setName("suzuki Dealer");
		storeEntity.setDescription("Car");		
		StoreEntity outcome  = storeController.addStore(storeEntity);		
		assertNotNull(outcome.getIdentifier());
		assertNotNull(outcome.getCreated());
		assertEquals("suzuki Dealer",outcome.getName());
		assertEquals("Car",outcome.getDescription());
	}
	
}
