package com.AppDirect.jBilling.product;

import static org.junit.Assert.*;

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
public class ProductServiceUnitTest {
	
	@Mock
	private ProductRepository productRepository;
	
	@InjectMocks
	private ProductServiceImpl productService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void addProductTest(){
		ProductEntity pe = new ProductEntity();
		pe.setBaseprice(54.45);
		pe.setName("MI");
		pe.setDescription("Phone");
		
		Mockito.when(productRepository.save(Mockito.any(ProductEntity.class))).thenReturn(pe);
		
		ProductEntity npe = productService.addProduct(pe);
		assertNotNull(npe);
		assertNotNull(npe.getIdentifier());
		assertEquals("MI",npe.getName());
		assertEquals("Phone",npe.getDescription());
	}

}
