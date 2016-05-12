package com.rbc.util;

import java.util.Arrays;

/**
 * Utility class to assist with the generation of hash codes.
 *
 * @author amit.x.sethi
 */
public final class HashCodeUtils {

	/**
	 * The initial value to be used when calculating a Hash Code.
	 */
	public static final int HASH_CODE_INITIAL = 17;

	/**
	 * The multiplier to be used when calculating a Hash Code.
	 */
	public static final int HASH_CODE_MULTIPLIER = 31;

	/**
	 * Returns the Hash Code for a <code>boolean</code>.
	 *
	 * @param hashCode the accumulating Hash Code.
	 * @param booleanValue the value to hash.
	 * @return the Hash Code for a <code>boolean</code>.
	 */
	public static int hashCode(int hashCode, boolean booleanValue) {
	    if (booleanValue) {
	        return hashCodeMultiply(hashCode) + 1;
	    } else {
	        return hashCodeMultiply(hashCode) + 0;
	    }
	}

	/**
	 * Returns the Hash Code for a <code>boolean[]</code>.
	 *
	 * @param hashCode the accumulating Hash Code.
	 * @param booleanArrayValue the value to hash.
	 * @return the Hash Code for a <code>boolean[]</code>.
	 */
	public static int hashCode(int hashCode, boolean[] booleanArrayValue) {
		return hashCodeMultiply(hashCode) + Arrays.hashCode(booleanArrayValue);
	}

	/**
	 * Returns the Hash Code for a <code>byte</code>.
	 *
	 * @param hashCode the accumulating Hash Code.
	 * @param byteValue the value to hash.
	 * @return the Hash Code for a <code>byte</code>.
	 */
	public static int hashCode(int hashCode, byte byteValue) {
		return hashCode(hashCode, (int) byteValue);
	}

	/**
	 * Returns the Hash Code for a <code>byte[]</code>.
	 *
	 * @param hashCode the accumulating Hash Code.
	 * @param byteArrayValue the value to hash.
	 * @return the Hash Code for a <code>byte[]</code>.
	 */
	public static int hashCode(int hashCode, byte[] byteArrayValue) {
		return hashCodeMultiply(hashCode) + Arrays.hashCode(byteArrayValue);
	}

	/**
	 * Returns the Hash Code for a <code>char</code>.
	 *
	 * @param hashCode the accumulating Hash Code.
	 * @param charValue the value to hash.
	 * @return the Hash Code for a <code>char</code>.
	 */
	public static int hashCode(int hashCode, char charValue) {
		return hashCode(hashCode, (int) charValue);
	}

	/**
	 * Returns the Hash Code for a <code>char[]</code>.
	 *
	 * @param hashCode the accumulating Hash Code.
	 * @param charArrayValue the value to hash.
	 * @return the Hash Code for a <code>char[]</code>.
	 */
	public static int hashCode(int hashCode, char[] charArrayValue) {
		return hashCodeMultiply(hashCode) + Arrays.hashCode(charArrayValue);
	}

	/**
	 * Returns the Hash Code for a <code>double[]</code>.
	 *
	 * @param hashCode the accumulating Hash Code.
	 * @param doubleArrayValue the value to hash.
	 * @return the Hash Code for a <code>double[]</code>.
	 */
	public static int hashCode(int hashCode, double[] doubleArrayValue) {
		return hashCodeMultiply(hashCode) + Arrays.hashCode(doubleArrayValue);
	}

	/**
	 * Returns the Hash Code for a <code>float[]</code>.
	 *
	 * @param hashCode the accumulating Hash Code.
	 * @param floatArrayValue the value to hash.
	 * @return the Hash Code for a <code>float[]</code>.
	 */
	public static int hashCode(int hashCode, float[] floatArrayValue) {
		return hashCodeMultiply(hashCode) + Arrays.hashCode(floatArrayValue);
	}

	/**
	 * Returns the Hash Code for an <code>int</code>.
	 *
	 * @param hashCode the accumulating Hash Code.
	 * @param intValue the value to hash.
	 * @return the Hash Code for an <code>int</code>.
	 */
	public static int hashCode(int hashCode, int intValue) {
		return hashCodeMultiply(hashCode) + intValue;
	}

	/**
	 * Returns the Hash Code for an <code>int[]</code>.
	 *
	 * @param hashCode the accumulating Hash Code.
	 * @param intArrayValue the value to hash.
	 * @return the Hash Code for an <code>int[]</code>.
	 */
	public static int hashCode(int hashCode, int[] intArrayValue) {
		return hashCodeMultiply(hashCode) + Arrays.hashCode(intArrayValue);
	}

	/**
	 * Returns the Hash Code for a <code>long</code>.
	 *
	 * @param hashCode the accumulating Hash Code.
	 * @param longValue the value to hash.
	 * @return the Hash Code for a <code>long</code>.
	 */
	public static int hashCode(int hashCode, long longValue) {
		return hashCodeMultiply(hashCode) +
		        (int) (longValue ^ (longValue >>> 32));
	}

	/**
	 * Returns the Hash Code for a <code>long[]</code>.
	 *
	 * @param hashCode the accumulating Hash Code.
	 * @param longArrayValue the value to hash.
	 * @return the Hash Code for a <code>long[]</code>.
	 */
	public static int hashCode(int hashCode, long[] longArrayValue) {
		return hashCodeMultiply(hashCode) + Arrays.hashCode(longArrayValue);
	}

	/**
	 * Returns the Hash Code for an <code>Object</code>.
	 *
	 * @param hashCode the accumulating Hash Code.
	 * @param objectValue the value to hash.
	 * @return the Hash Code for an <code>Object</code>.
	 */
	public static int hashCode(int hashCode, Object objectValue) {
	    if (objectValue == null) {
	        return hashCodeMultiply(hashCode) + 0;
	    } else {
	        return hashCodeMultiply(hashCode) + objectValue.hashCode();
	    }
	}

	/**
	 * Returns the Hash Code for an <code>Object[]</code>.
	 *
	 * @param hashCode the accumulating Hash Code.
	 * @param objectArrayValue the value to hash.
	 * @return the Hash Code for an <code>Object[]</code>.
	 */
	public static int hashCode(int hashCode, Object[] objectArrayValue) {
		return hashCodeMultiply(hashCode) + Arrays.hashCode(objectArrayValue);
	}

	/**
	 * Returns <code>HASH_CODE_MULTIPLIER * hashCode</code>.
	 *
	 * @param hashCode the accumulating Hash Code.
	 * @return <code>HASH_CODE_MULTIPLIER * hashCode</code>.
	 */
	public static int hashCodeMultiply(int hashCode) {
		return HASH_CODE_MULTIPLIER * hashCode;
	}

	/**
	 * <code>private</code> constructor to prevent instantiation.
	 */
	private HashCodeUtils() {
		 super();
	}
}
