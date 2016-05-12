package com.rbc.io;

import java.io.InputStreamReader;
import java.util.Collection;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.rbc.domain.Item;
import com.rbc.domain.Price;
import com.rbc.domain.PricedItem;
import com.rbc.domain.impl.ItemImpl;
import com.rbc.domain.impl.PriceImpl;
import com.rbc.domain.impl.PricedItemImpl;
import com.rbc.util.Constants;

/**
 * Loads the catalog of items from the xml document.
 *
 * @author amit.x.sethi
 */
public final class InventoryLoader {

	/**
	 * Loads the items from input xml document. if the xml is not valid returns
	 * empty <code>Collection</code> of <code>Item</code>s
	 *
	 * @return <code>Collection</code> of <code>Item</code>s loaded from input
	 *         xml document.
	 */
	public static Collection<PricedItem> loadItems(String filePath) {
		Collection<PricedItem> items = new TreeSet<PricedItem>();
		if (filePath != null) {
			try {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				InputStreamReader is = new InputStreamReader(InventoryLoader.class.getResourceAsStream(filePath));
				Document doc = dBuilder.parse(new InputSource(is));
				doc.getDocumentElement().normalize();
				NodeList itemList = doc.getElementsByTagName(Constants.ITEM);
				for (int i = 0; i < itemList.getLength(); i++) {
					Node nNode = itemList.item(i);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						String name = eElement.getElementsByTagName(Constants.NAME).item(0).getTextContent();
						String price = eElement.getElementsByTagName(Constants.PRICE).item(0).getTextContent();
						Item itemImpl = new ItemImpl(name);
						Price priceImpl = new PriceImpl(Double.valueOf(price));
						PricedItem pricedItem = new PricedItemImpl(itemImpl, priceImpl);
						if (pricedItem.getPrice().getAmount() >= 0.0) {
							items.add(pricedItem);
						} else {
							System.err.println("Invalid item found in the inventory. skipping the item" + pricedItem);
						}

					}
				}
			} catch (Exception e) {
				System.err.println("Exception while parsing the input xml ");
				e.printStackTrace();
			}
		}
		return items;
	}
}
