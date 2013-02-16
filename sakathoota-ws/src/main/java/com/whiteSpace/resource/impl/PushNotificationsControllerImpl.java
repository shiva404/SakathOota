/**
 * 
 */
package com.whiteSpace.resource.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.whiteSpace.resource.iface.FBRealTimeNotificationResource;
import com.whiteSpace.resource.iface.PushNotificationsController;
import com.whiteSpace.resource.json.types.Entry;
import com.whiteSpace.resource.json.types.FBNotification;

/**
 * @author Shivakumar N
 *
 * @since Jan 28, 2013 7:29:08 PM
 */
public class PushNotificationsControllerImpl implements PushNotificationsController {

	private FBRealTimeNotificationResource fbRealTimeNotificationResource;
	
	public FBRealTimeNotificationResource getFbRealTimeNotificationResource() {
		return fbRealTimeNotificationResource;
	}
	public void setFbRealTimeNotificationResource(FBRealTimeNotificationResource fbRealTimeNotificationResource) {
		this.fbRealTimeNotificationResource = fbRealTimeNotificationResource;
	}
	
	@Override
	public Response sendNotification(String userId) {
		FBNotification fbNotification = new FBNotification();
		Entry entry = new Entry();
		entry.setId(100001609165007L);
		entry.setUid(100001609165007L);
		List<String> changedFileds =  new ArrayList<String>();
		changedFileds.add("checkins");
		entry.setChanged_fields(changedFileds);
		fbNotification.getEntry().add(entry);
		fbRealTimeNotificationResource.postCallBackUrl(fbNotification);
		return null;
	}
	
}
