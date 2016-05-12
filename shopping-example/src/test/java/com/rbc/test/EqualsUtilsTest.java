package com.rbc.test;

import org.junit.Assert;
import org.junit.Test;

import com.rbc.util.EqualsUtils;

/**
 * Junit to test EqualsUtils utility.
 * 
 * @author amit.x.sethi
 */
public class EqualsUtilsTest {

	@Test
	public void testEquals() {
		String abc = "abc";
		String xyz = "xyz";
		String anotherXyz = "xyz";
		Assert.assertTrue(EqualsUtils.equals(null, null));
		Assert.assertFalse(EqualsUtils.equals(null, abc));
		Assert.assertFalse(EqualsUtils.equals(abc, null));
		Assert.assertTrue(EqualsUtils.equals(abc, abc));
		Assert.assertFalse(EqualsUtils.equals(abc, xyz));
		Assert.assertTrue(EqualsUtils.equals(anotherXyz, xyz));
	}

}
