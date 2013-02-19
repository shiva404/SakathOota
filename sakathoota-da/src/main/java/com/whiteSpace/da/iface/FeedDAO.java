/**
 * 
 */
package com.whiteSpace.da.iface;

import com.whiteSpace.domain.common.types.FeedItem;

/**
 * @author Shivakumar N
 *
 * @since Feb 19, 2013 12:01:41 AM
 */
public interface FeedDAO {
	public FeedItem createNewFeed(FeedItem feedItem);
}
