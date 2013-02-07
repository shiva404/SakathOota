/**
 * 
 */
package com.whiteSpace.da.iface;

import com.whiteSpace.domain.common.types.Item;

/**
 * @author Shivakumar N
 *
 * @since Feb 7, 2013 9:48:28 AM
 */
public interface ItemDAO {
	public Item createItem(Item item);
	public Item getItem(String id);
	public Item getAllItems();
}
