package com.AppDirect.jBilling.product;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ProductServiceIntegrationTest {
	
	@Autowired
	ProductService productService;
	
	@Test
	public void addProductTest(){
		ProductEntity pe = new ProductEntity();
		
		pe.setBaseprice(54.45);
		pe.setName("MI");
		pe.setDescription("Phone");
		
		
		ProductEntity npe = productService.addProduct(pe);
		
		assertNotNull(npe);
		assertNotNull(npe.getIdentifier());
		assertNotNull(npe.getCreated());
		assertEquals("MI",npe.getName());
		assertEquals("Phone",npe.getDescription());		
		
	}
	
	

}
