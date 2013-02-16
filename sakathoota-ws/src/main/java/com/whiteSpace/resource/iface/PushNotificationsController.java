/**
 * 
 */
package com.whiteSpace.resource.iface;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * @author Shivakumar N
 *
 * @since Jan 28, 2013 7:28:07 PM
 */
@Path("/pn")
public interface PushNotificationsController {

	@GET
	@Path("/{id}")
	public Response sendNotification(@PathParam("id") String userId);
}
