package com.AppDirect.jBilling.product.productDetail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

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
public class ProductDetailServiceUnitTest {
	
	@Mock
	private PriceRepository priceRepository;
	
	@InjectMocks
	private ProductDetailServiceImpl productDetailService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void addProductDetailTest(){

        PriceEntity pe = new PriceEntity();		
		pe.setProduct(UUID.fromString("9190e2fb-7283-4c10-9d37-e8d844e1d0fe"));
		pe.setStore(UUID.fromString("cee2fb68-c406-4c90-9593-134249165e2d"));
		pe.setPrice(76.99);
		pe.setNotes("Checked");
		
		Mockito.when(priceRepository.save(Mockito.any(PriceEntity.class))).thenReturn(pe);
		
		PriceEntity npe = productDetailService.addPrice(pe);
		assertNotNull(npe);
		assertEquals(UUID.fromString("9190e2fb-7283-4c10-9d37-e8d844e1d0fe").toString(),npe.getProduct().toString());
		assertEquals(UUID.fromString("cee2fb68-c406-4c90-9593-134249165e2d").toString(),npe.getStore().toString());
		assertEquals(76.99,npe.getPrice(),0.01);
	}	

}
