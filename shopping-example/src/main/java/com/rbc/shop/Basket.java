package com.rbc.shop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.rbc.domain.LineItem;
import com.rbc.util.EqualsUtils;
import com.rbc.util.HashCodeUtils;

/**
 * Represent a <code>Basket</code>.
 * 
 * @author amit.x.sethi
 */
public class Basket {

	private Collection<LineItem> lineItems = new ArrayList<LineItem>();

	/**
	 * Adds a <code>LineItem</code> to the <code>Basket</code>, and returns
	 * <code>true</code> if item successfully added, else <false>.
	 * 
	 * @param lineItem
	 *            - the <code>LineItem</code> to be added.
	 * @return <code>true</code> if item successfully added, else <false>.
	 */
	public boolean add(LineItem lineItem) {
		return lineItems.add(lineItem);
	}

	/**
	 * Removes a <code>LineItem</code> to the <code>Basket</code>, and returns
	 * <code>true</code> if item successfully removed, else <false>.
	 * 
	 * @param lineItem
	 *            - the <code>LineItem</code> to be removed.
	 * @return <code>true</code> if item successfully removed, else <false>.
	 */
	public boolean remove(LineItem lineItem) {
		return lineItems.remove(lineItem);
	}

	/**
	 * Returns the total cost of the basket.
	 * @return the total cost of the basket.
	 */
	public double getTotalCost() {
		double total = 0;
		for (LineItem lineItem : lineItems) {
			total = total + (lineItem.getQuantity() * lineItem.getPricedItem().getPrice().getAmount());
		}
		return total;
	}
	
	/**
	 * The all the <code>LineItem</code>s from the <code>Basket</code>.
	 * 
	 * @return all the <code>LineItem</code>s from the <code>Basket</code>.
	 */
	public Collection<LineItem> getLineItems() {
		return Collections.unmodifiableCollection(lineItems);
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean equal = false;
		if (obj != null && obj instanceof Basket) {
			Basket basket = (Basket) obj;
			if (EqualsUtils.equals(basket.getLineItems(), this.getLineItems())) {
				equal = true;
			}
		}
		return equal;
	}
	
	@Override
	public int hashCode() {
		int hashCode = HashCodeUtils.HASH_CODE_INITIAL;
		hashCode = HashCodeUtils.hashCode(hashCode, getLineItems());
		return hashCode;
	}
}
