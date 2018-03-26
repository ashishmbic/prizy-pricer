package com.AppDirect.jBilling.product.productDetail.idealPrice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AppDirect.jBilling.exception.InvalidCommandException;

@RestController
public class IdealPriceController {
	
	@Autowired
	private IdealPriceService idealPriceService;
	
	@RequestMapping(method=RequestMethod.POST,value="/jobs/pricecalculator")
	public ResponseEntity<Job> startJob(@RequestParam(value="command") String cmd){
		
		if(cmd.equals("start")){
		Job job = idealPriceService.startJob();
		return new ResponseEntity<Job>(job,HttpStatus.ACCEPTED);
	}
		throw new InvalidCommandException();
	}

}
