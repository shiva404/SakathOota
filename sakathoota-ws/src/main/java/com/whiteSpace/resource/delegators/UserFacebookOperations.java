/**
 * 
 */
package com.whiteSpace.resource.delegators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Checkin;

import com.whiteSpace.da.iface.ItemDAO;
import com.whiteSpace.da.iface.LocationDAO;
import com.whiteSpace.da.iface.MenuDAO;
import com.whiteSpace.da.iface.UserDataDAO;
import com.whiteSpace.domain.common.types.FeedItem;
import com.whiteSpace.domain.common.types.Item;
import com.whiteSpace.domain.common.types.Location;
import com.whiteSpace.domain.common.types.User;
import com.whiteSpace.resource.impl.FBDataAccess;
import com.whiteSpace.ws.commons.FB2NativeMapper;

/**
 * @author Shivakumar N
 *
 * @since Jan 29, 2013 7:06:44 PM
 */
public class UserFacebookOperations {
	
	 @Autowired
	 private UserDataDAO userDataDAO;
	 
	 @Autowired
	 private LocationDAO locationDAO;
	 
	 @Autowired
	 private ItemDAO itemDAO;
	 
	 @Autowired 
	 private MenuDAO menuDAO;
	 
	 private FBDataAccess fbDataAccess;
	
	public FBDataAccess getFbDataAccess() {
		return fbDataAccess;
	}

	public void setFbDataAccess(FBDataAccess fbDataAccess) {
		this.fbDataAccess = fbDataAccess;
	}

	public Location getLatestCheckin(String fbUserId){
		User user = userDataDAO.getUserByFBId(Long.parseLong(fbUserId));
		List<Checkin> checkins = fbDataAccess.getUserCheckins(user.getFbAccessToken());
		checkAndSaveToLocal(checkins);
		if (checkins.size() > 0) {
			Checkin latestCheckin = checkins.get(0);
			for (Checkin checkin : checkins) {
				if(latestCheckin.getCreatedTime().compareTo(checkin.getCreatedTime()) < 0){
					latestCheckin = checkin;
				}
			}
			Location location = FB2NativeMapper.mapLocation(latestCheckin);
			location.setUser(user);
			return location;
		}
		return null;
	}
	
	private void checkAndSaveToLocal(List<Checkin> checkins){
		//FIXME: Implement in efficient way(Add bulk API)
		for (Checkin checkin : checkins) {
			if(locationDAO.getLocationByFBLocationId(Long.parseLong(checkin.getPlace().getId())) == null){
				locationDAO.createLocation(FB2NativeMapper.mapLocation(checkin));
			}
		}
	}
	public void writeCheckinToFb(String fbUserId) {
		User user = userDataDAO.getUserByFBId(Long.parseLong(fbUserId));
		fbDataAccess.writeCheckinToFb(user.getFbAccessToken());
	}
	
	public void writeFeedToFB(FeedItem feedItem){
		User user = userDataDAO.getUserById(feedItem.getUserId().longValue());
		//FIXME: Write optimized query
		Location location = locationDAO.getLocationById(feedItem.getLocationId().longValue());
		Item item = null;
		if(feedItem.getMenuItemId() != null)
			 item = itemDAO.getItem(feedItem.getMenuItemId());
		
		else if(feedItem.getMenuId() != null){
			//Get Item id
		}
		String link = "http://www.tastebuddy.com/"; //Create a link to the location 
		//String link = "http://www.zurmat.com/wp-content/uploads/2010/09/chicken-biryani.jpg";
		String name = user.getName() + " rated " + item.getName() + "@" + location.getName();
		String caption = null ; //user.getName() + "rated an item";
		String message = item.getName() + " is awesome @" + location.getName() +" should try!!";
		
		String description = null;//user.getName() + "rated" + item.getName() + "@" + location.getName();
		
		String picture = "http://107.21.255.253:8080/images/chicken-biryani.jpg";
		String actions = null;
		
		fbDataAccess.writeFeedItemToFB(user.getFbAccessToken(), 
										link, 
										name, 
										caption, 
										description, 
										message, 
										picture, 
										actions);
	}
}
