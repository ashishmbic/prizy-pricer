package com.AppDirect.jBilling.product;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductRepositoryIntegrationTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	ProductRepository productRepository;
	
	@Test
	public void ProductRepositoryTest(){
		
		ProductEntity pe = new ProductEntity();
		UUID uuid =UUID.randomUUID();
		Date date = new Date();
		pe.setBaseprice(11.11);
		pe.setDescription("Notebook");
		pe.setCreated(date);
		pe.setName("Classmate");
		pe.setIdentifier(uuid);
		
		entityManager.persist(pe);
		
		ProductEntity product = productRepository.findOne(uuid);
		
		assertEquals(11.11,product.getBaseprice(),0.1);
		assertEquals("Notebook",product.getDescription());
		assertEquals("Classmate",product.getName());
		assertEquals(date.toString(),product.getCreated().toString());
	}

}
