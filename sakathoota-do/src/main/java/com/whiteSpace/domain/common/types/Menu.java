/**
 * 
 */
package com.whiteSpace.domain.common.types;

import java.util.List;

/**
 * @author Shivakumar N
 *
 * @since Feb 2, 2013 9:45:48 PM
 */
public class Menu {
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	public List<MenuItem> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
	private Integer locationId;
	private List<MenuItem> menuItems;
}
