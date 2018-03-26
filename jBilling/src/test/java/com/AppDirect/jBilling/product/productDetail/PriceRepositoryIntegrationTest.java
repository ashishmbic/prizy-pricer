package com.AppDirect.jBilling.product.productDetail;

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
public class PriceRepositoryIntegrationTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	PriceRepository priceRepository;
	
	@Test
	public void PriceRepositoryTest(){
		
		PriceEntity pe = new PriceEntity();
		
		Date date = new Date();
		
		pe.setNotes("OK");
		pe.setCreated(date);
		pe.setProduct(UUID.fromString("bebd95e9-ce34-4a76-8abc-3330ed38ddf9"));
		pe.setStore(UUID.fromString("4aa16ddb-5e67-446d-ae01-2fa03692f097"));
		pe.setPrice(Integer.MAX_VALUE);
		
		entityManager.persist(pe);
		
        PriceEntity pe2 = new PriceEntity();
		
		Date date2 = new Date();
		
		pe2.setNotes("OK");
		pe2.setCreated(date2);
		pe2.setProduct(UUID.fromString("bebd95e9-ce34-4a76-8abc-3330ed38ddf9"));
		pe2.setStore(UUID.fromString("cee2fb68-c406-4c90-9593-134249165e2d"));
		pe2.setPrice(Integer.MIN_VALUE);
		
		entityManager.persist(pe2);
		
		PriceEntity product1 = priceRepository.findFirstByProductOrderByPriceDesc(UUID.fromString("bebd95e9-ce34-4a76-8abc-3330ed38ddf9"));
		PriceEntity product2 = priceRepository.findFirstByProductOrderByPriceAsc(UUID.fromString("bebd95e9-ce34-4a76-8abc-3330ed38ddf9"));
		
		assertEquals("4aa16ddb-5e67-446d-ae01-2fa03692f097",product1.getStore().toString());
		assertEquals("cee2fb68-c406-4c90-9593-134249165e2d",product2.getStore().toString());
		
	}
	
}
