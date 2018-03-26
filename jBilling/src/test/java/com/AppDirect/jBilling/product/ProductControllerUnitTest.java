package com.AppDirect.jBilling.product;

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

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerUnitTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ProductService productService;
	
	@InjectMocks
	ProductController productController;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void addProductTest() throws Exception{
	UUID uuid = UUID.randomUUID();
	Date date = new Date();
	
	ProductEntity productEntity = new ProductEntity();
	productEntity.setName("Car");
	productEntity.setDescription("Travel");
	productEntity.setBaseprice(233.89);
	productEntity.setCreated(date);
	productEntity.setIdentifier(uuid);
	Mockito.when(productService.addProduct(Mockito.any(ProductEntity.class))).thenReturn(productEntity);
	
	String x = "{\"name\":\"Car\",\"description\":\"Travel\",\"baseprice\":233.89}";	
	
	String y = "{\"identifier\":\""+uuid.toString()+"\",\"name\":\"Car\",\"baseprice\":233.89,\"description\":\"Travel\"}";
	
	RequestBuilder requestBuilder = MockMvcRequestBuilders
			.post("/product")
			.accept(MediaType.APPLICATION_JSON).content(x)
			.contentType(MediaType.APPLICATION_JSON);
	
	MvcResult result = mockMvc.perform(requestBuilder).andReturn();

	MockHttpServletResponse response = result.getResponse();

	assertEquals(HttpStatus.OK.value(), response.getStatus());
	
	JSONAssert.assertEquals(y, result.getResponse()
			.getContentAsString(), false);
	
	}
	
}
