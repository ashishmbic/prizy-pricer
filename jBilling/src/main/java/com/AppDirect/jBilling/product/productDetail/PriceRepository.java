package com.AppDirect.jBilling.product.productDetail;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<PriceEntity,UUID>{
	
	int countByProduct(UUID  product);
	
	PriceEntity findFirstByProductOrderByPriceDesc(UUID product);
	PriceEntity findFirstByProductOrderByPriceAsc(UUID product);
	
	@Query(value = "SELECT avg(price) FROM price WHERE  pidentifier= ?1", nativeQuery = true)
	  double findByProduct(UUID product);
	
	
	@Query("SELECT DISTINCT product FROM PriceEntity")
	public List<UUID> getAllProducts();
	
	@Query(value = "Select price from price where pidentifier = ?1", nativeQuery = true )
	public List<Double> getAllPricesByProduct(UUID pid);
}


