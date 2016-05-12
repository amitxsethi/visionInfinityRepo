package com.rbc.shop;

import java.util.Collection;

import com.rbc.domain.PricedItem;
import com.rbc.io.InventoryLoader;
import com.rbc.util.Constants;

/**
 * This represent the complete catalog of the items in the shop.
 *
 * @author amit.x.sethi
 */
public final class Catalog {

	private Collection<PricedItem> pricedItems = null;
	
	private static Catalog catalog = null;
			
	/**
	 * Returns the instance of <code>Catalog</code>.
	 * @return the instance of <code>Catalog</code>.
	 */
	public static Catalog getInstance() {
		if (catalog == null) {
			catalog = new Catalog();
		}
		return catalog;
	}

	private Catalog() {
		super();
		pricedItems = InventoryLoader.loadItems(Constants.INVENTORY_XML);
	}

	/**
	 * Returns a <code>Collection</code> of <code>PricedItem</code> from the <code>Catalog</code>.
	 * @return <code>Collection</code> of <code>PricedItem</code> from the <code>Catalog</code>.
	 */
	public Collection<PricedItem> getPricedItems() {
		return pricedItems;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("======= CATALOG =========");
		sb.append(Constants.NEW_LINE);
		for (PricedItem pricedItem : pricedItems) {
			sb.append(pricedItem);
			sb.append(Constants.NEW_LINE);
		}
		sb.append("=========================");
		sb.append(Constants.NEW_LINE);
		return sb.toString();
	}
}
