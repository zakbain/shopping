package com.anna.goods;

import java.util.List;

public interface ProductFactory {
	/**
	 * Get an arbitrary product. 
	 * @return
	 *	a product
	 */
	public Product getAnyProduct();
	
	/**
	 * Get a list of arbitrary products
	 * 
	 * @param size
	 *	the number of products to build 	
	 * @return
	 * 	a list of products
	 */
	public List<Product> getAnyProducts(int size);
}
