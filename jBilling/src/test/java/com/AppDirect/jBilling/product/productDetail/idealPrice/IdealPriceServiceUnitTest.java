package com.AppDirect.jBilling.product.productDetail.idealPrice;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.NONE)
public class IdealPriceServiceUnitTest {
	
	@Mock
	private IdealPriceCalculator idealPriceCalculator;
	
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void startJobTest(){
		
		Mockito.when(idealPriceCalculator.updatePriceCache()).thenReturn("Current Job");
		
		Job job = new Job();
		
		job.setJob(idealPriceCalculator.updatePriceCache());
		
		assertEquals("Current Job",job.getJob());

	}

}
