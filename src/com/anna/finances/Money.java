package com.anna.finances;

// Fascinating. We have to enforce two money concepts: 1. generation must be regulated. 2. If I give you money, 
// I no longer have it

// Must create some way of representing a RequestMoney object vs Money object
// Also, is there a difference between a wallet and a bill/price? Or does the notion of an amount of money in a currency
// Properly serve both purposes (storing money, and representing a cost) - FOR NOW YES!
public interface Money {

	public float getBalance();
	
	public Currency getCurrency();
	
	public void setCurrency(Currency currency);
	
	public void deposit(Money money);
	
	public Money withdraw(Currency currency, float amount);
}
