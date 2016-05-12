package com.rbc.test;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.rbc.domain.Item;
import com.rbc.domain.LineItem;
import com.rbc.domain.PricedItem;
import com.rbc.domain.impl.ItemImpl;
import com.rbc.domain.impl.LineItemImpl;
import com.rbc.domain.impl.PriceImpl;
import com.rbc.domain.impl.PricedItemImpl;
import com.rbc.io.InventoryLoader;
import com.rbc.shop.Basket;
import com.rbc.shop.BasketFactory;
import com.rbc.util.Constants;

/**
 * Junit Test Case for Testing operations on Basket.
 * 
 * @author amit.x.sethi
 */
public class ShoppingBasketTest {

	private Collection<PricedItem> pricedItems = new HashSet<PricedItem>();
	private Item banana = new ItemImpl("Banana");
	private Item orange = new ItemImpl("Orange");
	private PricedItem bananaPricedItem = new PricedItemImpl(banana, new PriceImpl(2.00));
	private PricedItem orangePricedItem = new PricedItemImpl(orange, new PriceImpl(2.50));

	@Before
	public void setup() {
		pricedItems.addAll(InventoryLoader.loadItems(Constants.TEST_INVENTORY_XML));
	}

	/**
	 * Test case for testing the total cost of items in a basket
	 */
	@Test
	public void testBasketOperations() {
		Basket basket = BasketFactory.getBasket();
		
		int bananaQuantity = 5;
		int orangeQuantity = 10;
		double totalBananaCost = 10.0;
		double totalOrangeCost = 25.0;
		double totalCost = 35.0;
		double none = 0.0;

		// Empty basket cost
		Assert.assertEquals(none, basket.getTotalCost(), none);

		LineItem bananas = new LineItemImpl(bananaPricedItem, bananaQuantity);
		Assert.assertTrue(basket.add(bananas));
		Assert.assertEquals(totalBananaCost, basket.getTotalCost(), none);

		LineItem oranges = new LineItemImpl(orangePricedItem, orangeQuantity);
		Assert.assertTrue(basket.add(oranges));
		Assert.assertEquals(totalCost, basket.getTotalCost(), none);
		
		Assert.assertTrue(basket.remove(bananas));
		Assert.assertFalse(basket.remove(bananas));
		Assert.assertEquals(totalOrangeCost, basket.getTotalCost(), none);
		
		Assert.assertTrue(basket.remove(oranges));
		Assert.assertFalse(basket.remove(oranges));
		Assert.assertEquals(none, basket.getTotalCost(), none);
	}

	public void cleanup() {
		pricedItems.clear();
	}
}
