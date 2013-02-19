/**
 * 
 */
package com.whiteSpace.resource.iface;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.whiteSpace.domain.common.types.FeedItem;

/**
 * @author Shivakumar N
 *
 * @since Feb 2, 2013 11:52:43 AM
 */
@Path("/feed")
public interface Feed {
	@POST
	public Response newRating(FeedItem userEmotion);
	
	
}
