/**
 * 
 */
package com.whiteSpace.resource.impl;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.whiteSpace.domain.common.types.Item;
import com.whiteSpace.resource.iface.ItemsResource;

/**
 * @author Shivakumar N
 *
 * @since Feb 7, 2013 9:46:05 AM
 */
public class ItemsResourceImpl implements ItemsResource{

	@Autowired
	private ItemD
	
	@Override
	public Response createItem(Item item) {
		
		return null;
	}

	@Override
	public Response getItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getItem(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
