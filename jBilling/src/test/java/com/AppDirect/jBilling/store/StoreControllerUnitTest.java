package com.AppDirect.jBilling.store;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.UUID;

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
@WebMvcTest(StoreController.class)
public class StoreControllerUnitTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	StoreService storeService;
	
	@InjectMocks
	StoreController storeController;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void addStoreTest() throws Exception{
		
	
	UUID uuid = UUID.randomUUID();
	Date date = new Date();	
	StoreEntity storeEntity = new StoreEntity();
	storeEntity.setName("Suzuki Dealer");
	storeEntity.setDescription("Car");
	storeEntity.setCreated(date);
	storeEntity.setIdentifier(uuid);
	Mockito.when(storeService.addStore(Mockito.any(StoreEntity.class))).thenReturn(storeEntity);
	
	String x = "{\"name\":\"Suzuki Dealer\",\"description\":\"Car\"}";	
	
	String y = "{\"identifier\":\""+uuid.toString()+"\",\"name\":\"Suzuki Dealer\",\"description\":\"Car\"}";
	
	RequestBuilder requestBuilder = MockMvcRequestBuilders
			.post("/store")
			.accept(MediaType.APPLICATION_JSON).content(x)
			.contentType(MediaType.APPLICATION_JSON);
	
	MvcResult result = mockMvc.perform(requestBuilder).andReturn();

	MockHttpServletResponse response = result.getResponse();

	assertEquals(HttpStatus.OK.value(), response.getStatus());
	
	JSONAssert.assertEquals(y, result.getResponse()
			.getContentAsString(), false);	

}
	
}
