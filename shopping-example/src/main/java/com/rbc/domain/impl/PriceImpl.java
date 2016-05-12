package com.rbc.domain.impl;

import com.rbc.domain.Price;
import com.rbc.util.ComparableUtils;
import com.rbc.util.EqualsUtils;
import com.rbc.util.HashCodeUtils;

/**
 * <code>Price</code> Implementation.
 *
 * @author amit.x.sethi
 */
public class PriceImpl implements Price {

	private double amount;

	/**
	 * Constructor to create <code>PriceImpl</code>
	 * @param amount
	 */
	public PriceImpl(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public String toString() {
		return String.valueOf(amount);
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean equal = false;
		if (obj != null && obj instanceof PriceImpl) {
			PriceImpl priceImpl = (PriceImpl) obj;
			if (EqualsUtils.equals(priceImpl.getAmount(), this.getAmount())) {
				equal = true;
			}
		}
		return equal;
	}
	
	@Override
	public int hashCode() {
		int hashCode = HashCodeUtils.HASH_CODE_INITIAL;
		hashCode = HashCodeUtils.hashCode(hashCode, getAmount());
		return hashCode;
	}

	@Override
	public int compareTo(Price o) {
		if (o == null) {
			return -1;
		} else {
			return ComparableUtils.compareTo(getAmount(), o.getAmount());	
		}
	}
}
