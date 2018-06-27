package com.anna.finances;

public class DoroMoney implements Money {
	private Currency currency;
	private float balance;
	
	public DoroMoney(Currency currency, float initialBalance) {
		this.currency = currency;
		this.balance = initialBalance;
	}
	
	@Override
	public float getBalance() {
		return this.balance;
	}
	
	@Override
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Override
	public Currency getCurrency() {
		return this.currency;
	}

	@Override
	public void deposit(Money money) {
		if (currency == money.getCurrency()) {
			this.balance += money.getBalance();
		}
	}

	@Override
	public Money withdraw(Currency currency, float amount) {
		Money result = null;
		
		// Withdraw if currency matches. In future, we will handle conversion
		if (this.currency == currency) {
			if (amount < this.balance) {
				result = new DoroMoney(currency, amount);
				
				this.balance -= amount;
			}
		}
		
		return result;
	}

}
