/**
 * 
 */
package com.whiteSpace.ws.commons;

import java.io.InputStream;

import com.whiteSpace.domain.common.types.Notification;

import javapns.Push;

/**
 * @author Shivakumar N
 *
 * @since Feb 16, 2013 1:56:23 AM
 */
public class APNService {
	
	public void pushMessage(Notification notification, String deviceToken){
  	   InputStream in = this.getClass().getClassLoader().getResourceAsStream("PushCert.p12");
              try {
				Push.alert(notification.getData(), in, "tastebuddy", false, deviceToken);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args){
		APNService apnService = new APNService();
		Notification notification = new Notification();
		notification.setData("hello");
		apnService.pushMessage(notification, "42f38072e61bc15aa0d7bc596616403e20a3d230028657b448df514c7c4bfe07");
	}
}
