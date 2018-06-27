package com.anna.agents;
import java.util.List;

import com.anna.finances.Money;
import com.anna.goods.Product;

// How do we handle shopping carts? 

// What if the customer wants to organize his purchases more meaningfully
public interface Trader {
	
	public void addProduct(Product product);
	public List<Product> getProducts();

	public boolean trade(Product product, Money money );
	public boolean trade(Money money, Product product);
	public boolean trade(Product productGiven, Product productReceived);
	
	public float getBalance(); 

}



/* The current interaction is 
* 1. Trader A finds store
* 2. Trader A selects product (s)
* 3. Trader A asks Trader B, who has ability to sell from store, to purchase product
* 4. Trader B gives product and takes money 
* 4a. Seller interacts with customers purse?? 

* Q1 - Prove trader has enough money
*/



/*
*
* Interactions
* 	Trader 1 <-> Trader 2
* 	Trader 1 <-> Trader 2 <-> Store 
*
*/