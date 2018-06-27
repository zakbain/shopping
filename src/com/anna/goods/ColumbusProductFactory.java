package com.anna.goods;

import java.util.ArrayList;
import java.util.List;

public class ColumbusProductFactory {
	private static int ROTATOR = 0;
	private static final int DISTINCT_PRODUCTS = 3;
	
	/**
	 * Increment the rotator number
	 */
	private static void incRotator() {
		if (ROTATOR == DISTINCT_PRODUCTS - 1) {
			ROTATOR = 0;
		} else {
			ROTATOR++;
		}
	}
	
	public static Product getAnyProduct() {
		Product result; 
		
		// Pick one of three popular products based on rotator
		if (ROTATOR == 0) {
			result = new InterstellarB57();
		} else if (ROTATOR == 1) {
			result = new SoccerBall();
		} else {
			result = new JetPack();
		}
		
		incRotator();
		
		return result;
	}

	public static List<Product> getAnyProducts(int size) {
		List<Product> result = new ArrayList<>();
		
		for (int i = 0; i < size; i++) {
			result.add(getAnyProduct());
		}
		
		return result;
	}

}
