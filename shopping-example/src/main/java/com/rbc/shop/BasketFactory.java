package com.rbc.shop;

/**
 * Factory implementation
 *
 * @author amit.x.sethi
 */
public final class BasketFactory {

	private BasketFactory() {
		super();
	}

	/**
	 * Creates a new <code>Basket</code> and returns it.
	 * @return a new <code>Basket</code> object.
	 */
	public static Basket getBasket() {
		return new Basket();
	}
}
