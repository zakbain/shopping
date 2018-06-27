package com.anna.agents;

import java.util.ArrayList;
import java.util.List;

import com.anna.finances.Currency;
import com.anna.finances.DoroMoney;
import com.anna.finances.Money;
import com.anna.goods.ColumbusProductFactory;
import com.anna.goods.Product;
import com.anna.goods.ProductFactory;
import com.anna.places.Cafe;
import com.anna.places.Store;

public class FlorentineTrader implements Trader {
	private static final float DEFAULT_STARTING_BALANCE = 1000f;
	private List<Product> products;
	private Money purse;
	
	public FlorentineTrader() {
		this.products = new ArrayList<>();
		this.purse = new DoroMoney(Currency.DORO, DEFAULT_STARTING_BALANCE);
	}
	
	@Override
	public void addProduct(Product product) {
		this.products.add(product);
	}
	
	@Override
	public List<Product> getProducts() {
		return products;
	}

	@Override
	public boolean trade(Product product, Money money) {
		if (this.products.indexOf(product) >= 0) {
			this.products.remove(product);
			this.purse.deposit(money);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean trade(Money money, Product product) {
		products.add(product);
		purse.withdraw(money.getCurrency(), money.getBalance());
		
		return true;
	}

	@Override
	public boolean trade(Product productToGive, Product productToReceive) {
		int pos = this.products.indexOf(productToGive);
		
		if (pos >= 0) {
			this.products.remove(pos);
			this.products.add(pos, productToReceive);
			return true;
		}
		return false;
	}
	
	@Override
	public float getBalance() {
		return this.purse.getBalance();
	}
}
