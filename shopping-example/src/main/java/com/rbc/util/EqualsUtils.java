package com.rbc.util;

/**
 * Utility class to compare to equality of 2 objects in a null safe manner.
 * 
 * @author amit.x.sethi
 */
public final class EqualsUtils {

	/**
	 * <code>private</code> constructor to prevent instantiation.
	 */
	private EqualsUtils() {
		super();
	}

    /**
	 * <code>null</code> safe comparison between two <code>Objects</code>s.
	 *
	 * @param o1 the first <code>Object</code> to be compared.
	 * @param o2 the first <code>Object</code> to be compared.
	 * @return <code>true</code> if <code>o1</code> equals <code>o2</code>;
	 *         <code>false</code> otherwise.
	 */
	public static boolean equals(Object o1, Object o2) {
		if (o1 == o2) {
			return true;
		} else if ((o1 == null) || (o2 == null)) {
			return false;
		} else {
			return o1.equals(o2);
		}
	}
}
