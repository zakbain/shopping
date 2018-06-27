package com.anna.goods;

public class WorldProduct implements Product {
	private String name;
	private String description;
	
	// Tautological Constructor
	public WorldProduct(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
