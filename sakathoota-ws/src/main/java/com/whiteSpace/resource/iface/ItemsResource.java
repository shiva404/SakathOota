/**
 * 
 */
package com.whiteSpace.resource.iface;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.whiteSpace.domain.common.types.Item;

/**
 * @author Shivakumar N
 *
 * @since Feb 2, 2013 11:51:14 AM
 */
@Path("/items")
public interface ItemsResource {
	@POST
	public Response createItem(Item item);
	
	@GET
	public Response getItems();
	
	@GET
	@Path("/{id}")
	public Response getItem(@QueryParam("id") String id);
	
}
