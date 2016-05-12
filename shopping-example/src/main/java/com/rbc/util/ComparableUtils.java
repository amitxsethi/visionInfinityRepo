package com.rbc.util;

public final class ComparableUtils {

	/**
	 * Provides a null safe way of comparing 2 objects
	 * 
	 * @param comparable1 object 1 to Compare
	 * @param comparable2 object 2 to Compare
	 * @return a negative integer, zero, or a positive integer as this object is
	 *         less than, equal to, or greater than the specified object.
	 */
	public static <T extends Comparable<T>> int compareTo(T comparable1, T comparable2) {
		if (comparable1 == null && comparable2 == null) {
			return 0;
		} else if (comparable1 == null) {
			return -1;
		} else if (comparable2 == null) {
			return 1;
		} else
			return comparable1.compareTo(comparable2);
	}
}
