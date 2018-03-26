package com.AppDirect.jBilling.product.productDetail.idealPrice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IdealPriceControllerIntegrationTest {
	
	@Autowired
	IdealPriceController idc;
	
	@Test
	public void startJobTest(){
		
		assertNotNull(idc.startJob("start"));
	
	}

}
