package com.AppDirect.jBilling.product.productDetail;

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
@WebMvcTest(ProductDetailController.class)
public class ProductDetailControllerUnitTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ProductDetailService productDetailService;
	
	@InjectMocks
	ProductDetailController productDetailController;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void addPriceTest() throws Exception{
		
		UUID uuid1 =UUID.randomUUID();
		UUID uuid2 = UUID.randomUUID();
		
		PriceEntity priceEntity = new PriceEntity();
		priceEntity.setCreated(new Date());
		priceEntity.setNotes("OK");
		priceEntity.setPrice(43.77);
		priceEntity.setProduct(uuid1);
		priceEntity.setStore(uuid2);
		
		Mockito.when(productDetailService.addPrice(Mockito.any(PriceEntity.class))).thenReturn(priceEntity);
		
		String x = "{\"product\":\""+uuid1.toString()+"\",\"store\":\""+uuid2.toString()+"\",\"price\":43.77,\"notes\":\"OK\"}";
		String y = "{\"product\":\""+uuid1.toString()+"\",\"store\":\""+uuid2.toString()+"\",\"price\":43.77}";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/store/product")
				.accept(MediaType.APPLICATION_JSON).content(x)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		JSONAssert.assertEquals(y, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void getProductDetailsTest() throws Exception{
		
		UUID uuid = UUID.randomUUID();		
		ProductDetail productDetail = new ProductDetail();
		productDetail.setAveragePrice(56.99);
		productDetail.setBasePrice(65.55);
		productDetail.setCount(10);
		productDetail.setDescription("Vehicle");
		productDetail.setHighestPrice(90.00);
		productDetail.setIdealPrice(70.00);
		productDetail.setLowestPrice(40);
		productDetail.setName("Car");
		productDetail.setProduct(uuid);
		
		String y = "{\"product\":\""+uuid.toString()+"\",\"name\":\"Car\",\"description\":\"Vehicle\",\"basePrice\":65.55,\"averagePrice\":56.99,\"lowestPrice\":40,\"highestPrice\":90.00,\"idealPrice\":70.00,\"count\":10}";

		
		
		Mockito.when(productDetailService.getProductDetail(Mockito.any(String.class))).thenReturn(productDetail);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/product/"+uuid.toString()+"/prices")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		JSONAssert.assertEquals(y, result.getResponse()
				.getContentAsString(), false);
	}
	

}
