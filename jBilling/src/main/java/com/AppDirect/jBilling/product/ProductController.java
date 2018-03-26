package com.AppDirect.jBilling.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method=RequestMethod.POST,value="/product")
	public ProductEntity addProduct(@RequestBody ProductEntity product ){
		ProductEntity response = productService.addProduct(product);
		return response;
	}

}
