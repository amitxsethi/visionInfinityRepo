package com.rbc.domain;

/**
 * The <code>Item</code> interface.
 *
 * @author amit.x.sethi
 */
public interface Item extends Comparable<Item> {

	/**
	 * Returns the name of the <code>Item</code>.
	 *
	 * @return the name of the <code>Item</code>.
	 */
	String getName();
}
