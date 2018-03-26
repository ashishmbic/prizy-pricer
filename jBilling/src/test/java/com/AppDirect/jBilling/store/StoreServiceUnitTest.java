package com.AppDirect.jBilling.store;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.NONE)
public class StoreServiceUnitTest {
	
	@Mock
	private StoreRepository storeRepository;
	
	@InjectMocks
	private StoreServiceImpl storeService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void addProductTest(){
		StoreEntity pe = new StoreEntity();
		pe.setName("MI outlet");
		pe.setDescription("Pune");
		
		Mockito.when(storeRepository.save(Mockito.any(StoreEntity.class))).thenReturn(pe);
		
		StoreEntity npe = storeService.addStore(pe);
		assertNotNull(npe);
		assertNotNull(npe.getIdentifier());
		assertEquals("MI outlet",npe.getName());
		assertEquals("Pune",npe.getDescription());
	}

}
