package com.nithish.cartservice.utilities;

import java.math.BigDecimal;

import com.nithish.cartservice.entity.Product;

public class CartUtilities {
	
	public static BigDecimal getSubTotalForItem(Product product, int quantity){
	       return (product.getPrice()).multiply(BigDecimal.valueOf(quantity));
	    }

}
