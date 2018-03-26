package com.AppDirect.jBilling.product.productDetail;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductDetailControllerIntegrationTest {
	
	@Autowired
	ProductDetailController productDetailController;
	
	@Test
	public void addPriceTest(){
		PriceEntity pe = new PriceEntity();
		pe.setNotes("OK");
		pe.setPrice(89.99);
		pe.setProduct(UUID.fromString("8e7cc8db-1a68-4bc3-99fd-686f1307d542"));
		pe.setStore(UUID.fromString("cee2fb68-c406-4c90-9593-134249165e2d"));
		PriceEntity outcome  = productDetailController.addPrice(pe);
		assertNotNull(outcome.getCreated());
		assertEquals(89.90,outcome.getPrice(),0.1);
		assertEquals(UUID.fromString("cee2fb68-c406-4c90-9593-134249165e2d").toString(),outcome.getStore().toString());
		assertEquals(UUID.fromString("8e7cc8db-1a68-4bc3-99fd-686f1307d542").toString(),outcome.getProduct().toString());

	}
	
	@Test
	public void getProductDetails(){
		
		ProductDetail pd = productDetailController.getProductDetails("1d1b374e-176b-4925-a48d-637f507ae866");
		assertNotEquals(0.0,pd.getAveragePrice());
		assertNotEquals(0.0,pd.getBasePrice());
		assertNotEquals(0,pd.getCount());
		assertNotNull(pd.getDescription());
		assertNotEquals(0.0,pd.getHighestPrice());
		assertNotEquals(0.0,pd.getLowestPrice());
		assertNotNull(pd.getName());
		assertNotNull(pd.getProduct());
		
	}
	
}
