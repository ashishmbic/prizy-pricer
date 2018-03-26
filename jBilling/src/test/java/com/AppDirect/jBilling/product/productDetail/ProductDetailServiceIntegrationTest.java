package com.AppDirect.jBilling.product.productDetail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.AppDirect.jBilling.product.ProductEntity;
import com.AppDirect.jBilling.product.ProductService;
import com.AppDirect.jBilling.store.StoreEntity;
import com.AppDirect.jBilling.store.StoreService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ProductDetailServiceIntegrationTest {
	
	@Autowired
	ProductDetailService productDetailService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	StoreService storeService;
	
	@Test
	public void AddProductDetailTest(){
		PriceEntity pe = new PriceEntity();
		
		pe.setProduct(UUID.fromString("9190e2fb-7283-4c10-9d37-e8d844e1d0fe"));
		pe.setStore(UUID.fromString("cee2fb68-c406-4c90-9593-134249165e2d"));
		pe.setPrice(76.99);
		pe.setNotes("Checked");
		
		
		PriceEntity npe = productDetailService.addPrice(pe);
		
		assertNotNull(npe);
		assertEquals(UUID.fromString("9190e2fb-7283-4c10-9d37-e8d844e1d0fe").toString(),npe.getProduct().toString());
		assertEquals(UUID.fromString("cee2fb68-c406-4c90-9593-134249165e2d").toString(),npe.getStore().toString());
		assertEquals(76.99,npe.getPrice(),0.01);	
		
	}
	
	@Test
	public void GetProductDetailTest(){
		PriceEntity price1 = new PriceEntity();
		PriceEntity price2 = new PriceEntity();

		ProductEntity pe = new ProductEntity();
		
		pe.setBaseprice(54.45);
		pe.setName("MI 2");
		pe.setDescription("Phone");
		
		
		ProductEntity npe = productService.addProduct(pe);
		
		UUID pid = npe.getIdentifier();
		
		StoreEntity se1 = new StoreEntity();
		
		se1.setName("Amazon");
		se1.setDescription("Online");
		
		
		UUID sid1 = storeService.addStore(se1).getIdentifier();
		
        StoreEntity se2 = new StoreEntity();
		
		se2.setName("eBay");
		se2.setDescription("Online");
		
		
		UUID sid2 = storeService.addStore(se2).getIdentifier();
		
		price1.setProduct(pid);
		price1.setStore(sid1);
		price1.setPrice(545.00);
		price1.setNotes("Checked");
		productDetailService.addPrice(price1);
		price2.setProduct(pid);
		price2.setStore(sid2);
		price2.setPrice(382.00);
		price2.setNotes("checked");
		productDetailService.addPrice(price2);
		
		ProductDetail pd = productDetailService.getProductDetail(pid.toString());
		
		assertNotNull(pd);
		assertEquals(pid.toString(),pd.getProduct().toString());
		assertEquals("MI 2",pd.getName());
		assertEquals("Phone",pd.getDescription());
		assertEquals(54.45,pd.getBasePrice(),0.1);
		assertEquals(2,pd.getCount());
		assertEquals(545.00,pd.getHighestPrice(),1.0);
		assertEquals(382.00,pd.getLowestPrice(),1.0);
		assertEquals((545.00+382.00)/2,pd.getAveragePrice(),0.1);
		assertEquals(0,pd.getIdealPrice(),0.1);
	}
	

}
