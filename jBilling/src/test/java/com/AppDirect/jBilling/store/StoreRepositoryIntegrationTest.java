package com.AppDirect.jBilling.store;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class StoreRepositoryIntegrationTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	StoreRepository storeRepository;
	
	@Test
	public void StoreRepositoryTest(){
		StoreEntity pe = new StoreEntity();
		UUID uuid =UUID.randomUUID();
		Date date = new Date();
		pe.setDescription("Dealer");
		pe.setCreated(date);
		pe.setName("Suzuki");
		pe.setIdentifier(uuid);
		
		entityManager.persist(pe);
		
		StoreEntity product = storeRepository.findOne(uuid);
		
		assertEquals("Dealer",product.getDescription());
		assertEquals("Suzuki",product.getName());
		assertEquals(date.toString(),product.getCreated().toString());
	
	}
	

}
