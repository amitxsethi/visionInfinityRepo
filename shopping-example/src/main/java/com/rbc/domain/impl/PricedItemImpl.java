package com.rbc.domain.impl;

import com.rbc.domain.Item;
import com.rbc.domain.Price;
import com.rbc.domain.PricedItem;
import com.rbc.util.ComparableUtils;
import com.rbc.util.EqualsUtils;
import com.rbc.util.HashCodeUtils;

/**
 * <code>PricedItem</code> Implementation.
 *
 * @author amit.x.sethi
 */
public class PricedItemImpl implements PricedItem {

	private Item item;
	private Price price;

	/**
	 * @param item
	 * @param price
	 */
	public PricedItemImpl(Item item, Price price) {
		this.item = item;
		this.price = price;
	}

	public Item getItem() {
		return item;
	}

	public Price getPrice() {
		return price;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(item);
		sb.append(" @ ");
		sb.append(price);
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean equal = false;
		if (obj != null && obj instanceof PricedItemImpl) {
			PricedItemImpl pricedItemImpl = (PricedItemImpl) obj;
			if (EqualsUtils.equals(pricedItemImpl.getItem(), this.getItem()) && 
					EqualsUtils.equals(pricedItemImpl.getPrice(), this.getPrice())) {
				equal = true;
			}
		}
		return equal;
	}
	
	@Override
	public int hashCode() {
		int hashCode = HashCodeUtils.HASH_CODE_INITIAL;
		hashCode = HashCodeUtils.hashCode(hashCode, getItem());
		hashCode = HashCodeUtils.hashCode(hashCode, getPrice());
		return hashCode;
	}
	
	@Override
	public int compareTo(PricedItem o) {
		if (o == null) {
			return -1;
		} else {
			int compare = 0;
			compare = ComparableUtils.compareTo(getItem(), o.getItem());
			if (compare == 0) {
				compare = ComparableUtils.compareTo(getPrice(), o.getPrice());
			}
			return compare;	
		}
	}
}
