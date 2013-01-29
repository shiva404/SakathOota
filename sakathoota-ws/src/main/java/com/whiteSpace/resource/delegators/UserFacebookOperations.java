/**
 * 
 */
package com.whiteSpace.resource.delegators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Checkin;

import com.whiteSpace.da.iface.UserDataDAO;
import com.whiteSpace.domain.common.types.User;
import com.whiteSpace.resource.impl.FBDataAccess;

/**
 * @author Shivakumar N
 *
 * @since Jan 29, 2013 7:06:44 PM
 */
public class UserFacebookOperations {
	
	 @Autowired
	 private UserDataDAO userDataDAO;
	 
	 private FBDataAccess fbDataAccess;
	
	public FBDataAccess getFbDataAccess() {
		return fbDataAccess;
	}

	public void setFbDataAccess(FBDataAccess fbDataAccess) {
		this.fbDataAccess = fbDataAccess;
	}

	public Checkin getLatestCheckin(String fbId){
		User user = userDataDAO.getUserByFBId(Long.parseLong(fbId));
		Checkin checkin = fbDataAccess.getUserLatestCheckin(user.getFbAccessToken());
		return checkin;
	}
}
