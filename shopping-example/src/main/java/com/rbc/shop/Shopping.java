package com.rbc.shop;

import java.util.Scanner;

import com.rbc.domain.PricedItem;
import com.rbc.domain.impl.LineItemImpl;

/**
 * This is the main class.
 * Expects users inputs of quantity when asked on console.
 *
 * @author amit.x.sethi
 */
public class Shopping {

	/**
	 * The main method to execute the <code>Shopping</code>.
	 * @param args arguments for the main method.
	 */
	public static void main(String[] args) {
		Catalog catalog = Catalog.getInstance();
		System.out.print(catalog);
		Basket basket = BasketFactory.getBasket();
		Scanner scanner = new Scanner(System.in);
		for (PricedItem pricedItem : catalog.getPricedItems()) {
			System.out.println("Please enter the number of " + pricedItem + " required");
			try {
				int quantity = scanner.nextInt();
				if (quantity < 0) {
					exitAsInvalidInput();
				}
				basket.add(new LineItemImpl(pricedItem, quantity));
			} catch (java.util.InputMismatchException e) {
				scanner.close();
				e.printStackTrace();
				exitAsInvalidInput();
			} 
		}
		scanner.close();
		System.out.println("Thank you for shopping. Your total cost of basket is calaculated as GBP " + basket.getTotalCost());
	}

	/**
	 * Ensures that the program exits if incorrectly accessed.
	 */
	private static void exitAsInvalidInput() {
		System.out.println(
				"You have entered invalid input. Exiting the system now.");
		System.exit(0);
	}
}
