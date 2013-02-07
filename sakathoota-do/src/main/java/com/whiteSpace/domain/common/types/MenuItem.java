/**
 * 
 */
package com.whiteSpace.domain.common.types;

/**
 * @author Shivakumar N
 *
 * @since Feb 2, 2013 9:46:03 PM
 */
public class MenuItem {
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	private Integer id;
	private Integer locationId;
	private Integer itemId;
}
