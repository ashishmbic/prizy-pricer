package com.AppDirect.jBilling.product;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductControllerIntegrationTest {
	
	@Autowired
	ProductController productController;
	
	@Test
	public void addProductTest(){
		ProductEntity productEntity = new ProductEntity();
		productEntity.setName("Car");
		productEntity.setDescription("Travel");
		productEntity.setBaseprice(33.89);		
		ProductEntity outcome  = productController.addProduct(productEntity);		
		assertNotNull(outcome.getIdentifier());
		assertNotNull(outcome.getCreated());
		assertEquals("Car",outcome.getName());
		assertEquals("Travel",outcome.getDescription());
		assertEquals(33.89,outcome.getBaseprice(),0.1);
	}
	
}
