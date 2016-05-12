package com.rbc.domain;

/**
 * The <code>PricedItem</code> interface.
 *
 * @author amit.x.sethi
 */
public interface PricedItem extends Comparable<PricedItem>  {

	/**
	 * Returns the <code>Item</code>.
	 *
	 * @return the <code>Item</code>.
	 */
	Item getItem();

	/**
	 * Returns the <code>Price</code>.
	 *
	 * @return the <code>Price</code>.
	 */
	Price getPrice();
}
