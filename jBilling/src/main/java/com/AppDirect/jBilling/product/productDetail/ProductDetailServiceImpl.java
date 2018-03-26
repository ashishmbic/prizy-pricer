package com.AppDirect.jBilling.product.productDetail;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AppDirect.jBilling.product.ProductEntity;
import com.AppDirect.jBilling.product.ProductRepository;
import com.AppDirect.jBilling.product.productDetail.idealPrice.IdealPriceService;

@Service
public class ProductDetailServiceImpl implements ProductDetailService{	

	@Autowired
	private PriceRepository priceRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private IdealPriceService idealPriceService;
	
	public PriceEntity addPrice(PriceEntity price){
		
		price.setCreated(new Date());
		priceRepository.save(price);
		return price;
	}
	
	public ProductDetail getProductDetail(String id){
		
		UUID pid = UUID.fromString(id);
		ProductDetail productDetail = new ProductDetail();
		
		ProductEntity productEntity = productRepository.findOne(pid);
		
		productDetail.setName(productEntity.getName());
		productDetail.setDescription(productEntity.getDescription());
		productDetail.setBasePrice(productEntity.getBaseprice());
		productDetail.setProduct(productEntity.getIdentifier());
		productDetail.setCount(priceRepository.countByProduct(pid));
		productDetail.setHighestPrice(priceRepository.findFirstByProductOrderByPriceDesc(pid).getPrice());       
		productDetail.setLowestPrice(priceRepository.findFirstByProductOrderByPriceAsc(pid).getPrice());
		productDetail.setAveragePrice(priceRepository.findByProduct(pid));
	    productDetail.setIdealPrice(idealPriceService.getIdealPrice(pid));
		return productDetail;
		
	}

}
