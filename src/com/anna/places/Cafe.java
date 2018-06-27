package com.anna.places;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.anna.agents.FlorentineTrader;
import com.anna.agents.Trader;
import com.anna.finances.Currency;
import com.anna.finances.DoroMoney;
import com.anna.finances.Money;
import com.anna.goods.ColumbusProductFactory;
import com.anna.goods.Product;
import com.anna.utility.PricesBuilder;

// Todo: make sure cafe has the products it sells
public class Cafe implements Store {
	private List<Product> products;
	private Money cashRegister;
	private static final int PRODUCT_COUNT = 4;
	
	// Todo: Abstract prices
	private Map<Product, Money> productPrices;
	
	public Cafe(Map<Product, Money> productPrices) {
		this.productPrices = productPrices;
		
		products = ColumbusProductFactory.getAnyProducts(PRODUCT_COUNT);
		cashRegister = new DoroMoney(Currency.DORO, 1000f);
	}
	
	@Override	
	public Money getCashRegister() {
		return this.cashRegister;
	}
	
	
	public void setProductPrices(Map<Product, Money> productPrices) {
		this.productPrices = productPrices;
	}
	
	// Todo: Restrict access; handle for here or to go
	public Map<Product, Money> getProductPrices() {
		return this.productPrices;
	}
	
	// Tell the store I bought the product.
	public boolean buyProduct(Product product, Money price) {
		// TODO: impact stock of the product. Add to records. Print receipt?
		this.cashRegister.deposit(price);
		
		return true;
	}
	
	public static void main(String[] args) {
		Cafe kerouac = new Cafe(PricesBuilder.buildProductPrices(StoreType.LOCALCOFFEE));
		
		// Now, have a chick buy a product
		Trader lucrezia = new FlorentineTrader();
		System.out.println("Lucrezia's Products: " + lucrezia.getProducts());
		System.out.println("Lucrezia's Balance: " + lucrezia.getBalance());
		
		Random random = new Random();
		int purchaseIndex = random.nextInt(PRODUCT_COUNT);
		Iterator<Product> productIterator = kerouac.getProductPrices().keySet().iterator();
		
		Product productToBuy = null;
		for (int i = 0; i < purchaseIndex; i++) {
			productIterator.next();
		}

		productToBuy = productIterator.next();
		System.out.println("Product to buy: " + productToBuy.toString());
		
		Money productPrice = kerouac.getProductPrices().get(productToBuy);
		
		lucrezia.trade(productPrice, productToBuy);
		kerouac.buyProduct(productToBuy, productPrice);
		System.out.println("---- Transaction complete ----");
		
		System.out.println("Lucrezia's Products: " + lucrezia.getProducts());
		System.out.println("Lucrezia's Balance: " + lucrezia.getBalance());

	}

}
