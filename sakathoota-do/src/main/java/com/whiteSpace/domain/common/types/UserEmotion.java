/**
 * 
 */
package com.whiteSpace.domain.common.types;

/**
 * @author Shivakumar N
 *
 * @since Feb 2, 2013 9:46:53 PM
 */
public class UserEmotion {
	private Integer userId;
	private Integer menuId;
	private Integer locationId;
	private Integer menuItemId;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	public Integer getMenuItemId() {
		return menuItemId;
	}
	public void setMenuItemId(Integer menuItemId) {
		this.menuItemId = menuItemId;
	}
}
