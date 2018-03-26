package com.AppDirect.jBilling.product;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	public ProductEntity addProduct(ProductEntity product){		
		product.setCreated(new Date());
		product.setIdentifier(UUID.randomUUID());
		productRepository.save(product);
		return product;
	}
}
