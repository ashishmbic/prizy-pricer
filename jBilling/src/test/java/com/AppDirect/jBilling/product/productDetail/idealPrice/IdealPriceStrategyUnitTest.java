package com.AppDirect.jBilling.product.productDetail.idealPrice;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
public class IdealPriceStrategyUnitTest {
	
	@Test
    public void properIdealPriceValues(){					
        IdealPriceStrategyImpl ips = new IdealPriceStrategyImpl();
        List<Double> listPrices = new ArrayList<Double>();        
        listPrices.add(1.0);
        listPrices.add(2.0);
        listPrices.add(3.0);
        listPrices.add(4.0);
        listPrices.add(5.0);
        listPrices.add(6.0);
        listPrices.add(7.0);
        listPrices.add(8.0);
        
        double x =ips.calculateIdealPrice(listPrices);
        double y = ips.calculateIdealPrice(listPrices.subList(1, 3));
        double z = ips.calculateIdealPrice(listPrices.subList(1, 5));
        
        assertEquals(5.4,x,0.1); // Number of items greater than 4
        assertEquals(0,y,0.1); // Number of items less than 4
        assertEquals(0,z,0.1); //Number of items equal to 4
    }

	}
	
	


