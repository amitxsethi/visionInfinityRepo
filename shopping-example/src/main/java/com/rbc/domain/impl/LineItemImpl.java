package com.rbc.domain.impl;

import com.rbc.domain.LineItem;
import com.rbc.domain.PricedItem;
import com.rbc.util.ComparableUtils;
import com.rbc.util.EqualsUtils;
import com.rbc.util.HashCodeUtils;

/**
 * <code>LineItem</code> Implementation.
 *
 * @author amit.x.sethi
 */
public class LineItemImpl implements LineItem {

	private PricedItem pricedItem;
	private int Quantity;

	public PricedItem getPricedItem() {
		return pricedItem;
	}

	public int getQuantity() {
		return Quantity;
	}

	/**
	 * @param pricedItem
	 * @param quantity
	 */
	public LineItemImpl(PricedItem pricedItem, int quantity) {
		this.pricedItem = pricedItem;
		this.Quantity = quantity;
	}

	@Override
	public boolean equals(Object obj) {
		boolean equal = false;
		if (obj != null && obj instanceof LineItemImpl) {
			LineItemImpl lineItemImpl = (LineItemImpl) obj;
			if (EqualsUtils.equals(lineItemImpl.getPricedItem(), this.getPricedItem()) && 
					lineItemImpl.getQuantity() == this.getQuantity()) {
				equal = true;
			}
		}
		return equal;
	}

	@Override
	public int hashCode() {
		int hashCode = HashCodeUtils.HASH_CODE_INITIAL;
		hashCode = HashCodeUtils.hashCode(hashCode, getQuantity());
		hashCode = HashCodeUtils.hashCode(hashCode, getPricedItem());
		return hashCode;
	}
	
	@Override
	public int compareTo(LineItem o) {
		if (o == null) {
			return -1;
		} else {
			int compare = 0;
			compare = ComparableUtils.compareTo(getPricedItem(), o.getPricedItem());
			if (compare == 0) {
				compare = ComparableUtils.compareTo(getQuantity(), o.getQuantity());
			}
			return compare;	
		}
	}
}
