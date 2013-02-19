/**
 * 
 */
package com.whiteSpace.resource.impl;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.whiteSpace.da.iface.FeedDAO;
import com.whiteSpace.domain.common.types.FeedItem;
import com.whiteSpace.resource.delegators.UserFacebookOperations;
import com.whiteSpace.resource.iface.Feed;

/**
 * @author Shivakumar N
 *
 * @since Feb 18, 2013 11:59:05 PM
 */
public class FeedImpl implements Feed {
	
	@Autowired
	private FeedDAO feedDAO;

	private UserFacebookOperations userFacebookOperations;

	public void setUserFacebookOperations(UserFacebookOperations userFacebookOperations) {
		this.userFacebookOperations = userFacebookOperations;
		
		
	}
	
	/* (non-Javadoc)
	 * @see com.whiteSpace.resource.iface.Feed#newRating(com.whiteSpace.domain.common.types.UserEmotion)
	 */
	@Override
	@POST
	public Response newRating(FeedItem feedItem) {
		//Write logic to construct the menuItem from the place and the item
		feedDAO.createNewFeed(feedItem);
		userFacebookOperations.writeFeedToFB(feedItem);
		return null;
	}

}
