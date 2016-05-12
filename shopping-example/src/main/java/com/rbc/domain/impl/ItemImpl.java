package com.rbc.domain.impl;

import com.rbc.domain.Item;
import com.rbc.util.EqualsUtils;
import com.rbc.util.HashCodeUtils;

/**
 * <code>Item</code> Implementation.
 * 
 * @author amit.x.sethi
 */
public class ItemImpl implements Item {

	private String name;

	/**
	 * Constructor for creating an <code>Item</code>.
	 *
	 * @param name - the name of the Item
	 */
	public ItemImpl(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return getName();
	}

	@Override
	public boolean equals(Object obj) {
		boolean equal = false;
		if ((obj != null) && (obj instanceof ItemImpl)) {
			ItemImpl item = (ItemImpl) obj;
			if (EqualsUtils.equals(item.getName(), this.getName())) {
				equal = true;
			}
		}
		return equal;
	}
	
	@Override
	public int hashCode() {
		int hashCode = HashCodeUtils.HASH_CODE_INITIAL;
		hashCode = HashCodeUtils.hashCode(hashCode, getName());
		return hashCode;
	}

	@Override
	public int compareTo(Item o) {
		if (o == null || o.getName() == null) {
			return -1;
		} else {
			return  this.getName().compareTo(o.getName()) ;	
		}
	}
}

