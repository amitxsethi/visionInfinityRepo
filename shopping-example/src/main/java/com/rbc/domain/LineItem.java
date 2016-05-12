package com.rbc.domain;

/**
 * A LineItem consists of <code>PricedItem</code> and it's <code>quantity</code>.
 *
 * @author amit.x.sethi
 */
public interface LineItem extends Comparable<LineItem> {

	/**
	 * Returns the <code>PricedItem</code> of the <code>LineItem</code>.
	 *
	 * @return the <code>PricedItem</code> of the <code>LineItem</code>.
	 */
	public PricedItem getPricedItem();

	/**
	 * Returns the quantity of the <code>LineItem</code>.
	 *
	 * @return the quantity of the <code>LineItem</code>.
	 */
	public int getQuantity();

}
