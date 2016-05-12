package com.rbc.test;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.rbc.domain.Item;
import com.rbc.domain.PricedItem;
import com.rbc.domain.impl.ItemImpl;
import com.rbc.domain.impl.PriceImpl;
import com.rbc.domain.impl.PricedItemImpl;
import com.rbc.io.InventoryLoader;
import com.rbc.util.Constants;

/**
 * Junit Test Case for Testing InventoryLoader.
 * 
 * @author amit.x.sethi
 */
public class InventoryLoaderTest {

	private Collection<PricedItem> pricedItems = new HashSet<PricedItem>();
	private Item banana = new ItemImpl("Banana");
	private Item orange = new ItemImpl("Orange");
	private PricedItem bananaPricedItem = new PricedItemImpl(banana, new PriceImpl(2.00));
	private PricedItem orangePricedItem = new PricedItemImpl(orange, new PriceImpl(2.50));

	@Before
	public void setup() {
		pricedItems.addAll(InventoryLoader.loadItems(Constants.TEST_INVENTORY_XML));
	}

	@Test
	public void testInventoryLoader() {
		Assert.assertTrue(pricedItems.size() == 2);
		Assert.assertTrue(pricedItems.stream().anyMatch(pricedItem -> pricedItem.equals(bananaPricedItem)));
		Assert.assertTrue(pricedItems.stream().anyMatch(pricedItem -> pricedItem.equals(orangePricedItem)));
	}

	public void cleanup() {
		pricedItems.clear();
	}
}
