package com.anna.utility;

import java.util.HashMap;
import java.util.Map;

import com.anna.finances.Currency;
import com.anna.finances.DoroMoney;
import com.anna.finances.Money;
import com.anna.goods.Product;
import com.anna.goods.WorldProduct;
import com.anna.places.StoreType;

public class PricesBuilder {

	// Builds a simple menu of coffee, plain bagel, tea, and a croissant
	private static Map<Product, Money> buildLocalCoffeePrices() {
		Map<Product, Money> prices = new HashMap<>();

		Product coffee = new WorldProduct("Coffee", "A bitter liquid with lots of caffeine.");
		Product tea = new WorldProduct("Tea", "A mild liquid with a little caffeine.");
		Product bagel = new WorldProduct("Bagel", "A dense, circular, filling bread.");
		Product croissant = new WorldProduct("Croissant", "An intricate buttery rolled bread.");
		

		prices.put(coffee, new DoroMoney(Currency.DORO, 4f));
		prices.put(tea, new DoroMoney(Currency.DORO, 4f));
		prices.put(bagel, new DoroMoney(Currency.DORO, 5f));
		prices.put(croissant, new DoroMoney(Currency.DORO, 5f));
		
		return prices;
	}
	
	private static Map<Product, Money> buildScamPrices() {
		Map<Product, Money> result = new HashMap<>();
		result.put(new WorldProduct("Clay", "A \"rare\" material"), new DoroMoney(Currency.DORO, 4000000f));
		return result;
	}
	
	public static Map<Product, Money> buildProductPrices(StoreType storeType) {
		Map<Product, Money> result = new HashMap<>();
		switch (storeType) {
			case LOCALCOFFEE:
				result = buildLocalCoffeePrices();
				break;
				
			default:
				result = buildScamPrices();
				break;
					
		}
		
		return result;
	}
}
