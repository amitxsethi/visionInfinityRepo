package com.rbc.domain;

/**
 * The <code>Price</code> interface.
 *
 * @author amit.x.sethi
 */
public interface Price extends Comparable<Price>{

	/**
	 * Returns the amount.
	 *
	 * @return the amount.
	 */
	public double getAmount();
}
