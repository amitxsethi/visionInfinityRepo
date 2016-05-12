package com.rbc.test;

import org.junit.Assert;
import org.junit.Test;

import com.rbc.util.ComparableUtils;

public class ComparableUtilsTest {

	@Test
	public void testCompareTo() {
		String comparable1 = null;
		String comparable2 = "abc";
		String comparable3 = "xyz";

		Assert.assertTrue(ComparableUtils.compareTo(comparable1, comparable2) < 0);
		Assert.assertTrue(ComparableUtils.compareTo(comparable2, comparable1) > 0);
		Assert.assertTrue(ComparableUtils.compareTo(comparable1, comparable1) == 0);
		Assert.assertTrue(ComparableUtils.compareTo(comparable2, comparable2) == 0);
		Assert.assertTrue(ComparableUtils.compareTo(comparable2, comparable3) < 1);

	}
}
