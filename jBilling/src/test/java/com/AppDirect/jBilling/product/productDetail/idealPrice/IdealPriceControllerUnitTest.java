package com.AppDirect.jBilling.product.productDetail.idealPrice;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(IdealPriceController.class)
public class IdealPriceControllerUnitTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	IdealPriceService idealPriceService;
	
	@InjectMocks
	IdealPriceController idealPriceController;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void startJobTest() throws Exception{
		
		Job job = new Job();
		Date date = new Date();
		job.setJob("Current Job");
		job.setStarted(date);
		Mockito.when(idealPriceService.startJob()).thenReturn(job);
		
		String x = "{\"job\": \"Current Job\"}";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/jobs/pricecalculator?command=start")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		
		RequestBuilder requestBuilder2 = MockMvcRequestBuilders
				.post("/jobs/pricecalculator?command=RandomCommand")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MvcResult result2 = mockMvc.perform(requestBuilder2).andReturn();

		MockHttpServletResponse response = result.getResponse();
		MockHttpServletResponse response2 = result2.getResponse();


		assertEquals(HttpStatus.ACCEPTED.value(), response.getStatus());
		assertEquals(HttpStatus.BAD_REQUEST.value(), response2.getStatus());
		
		JSONAssert.assertEquals(x, result.getResponse()
				.getContentAsString(), false);
	}
}
