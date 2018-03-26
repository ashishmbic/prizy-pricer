package com.AppDirect.jBilling.product.productDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductDetailController {
	
	@Autowired
	private ProductDetailService productDetailService;
	
	/*This URL is for adding prices*/
	@RequestMapping(method=RequestMethod.POST,value="/store/product")
	public PriceEntity addPrice(@RequestBody PriceEntity price ){
		PriceEntity response = productDetailService.addPrice(price);
		return response;
	}
	
	/*This URL is for fetching product details*/
	@RequestMapping("/product/{product-identifier}/prices")
	public ProductDetail getProductDetails(@PathVariable(value="product-identifier") String pid){
		ProductDetail response  = productDetailService.getProductDetail(pid);
		return response;
		
	}

}
