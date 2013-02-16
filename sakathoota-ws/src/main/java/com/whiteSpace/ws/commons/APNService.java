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
  	   InputStream in = this.getClass().getClassLoader().getResourceAsStream("SakathOota.p12");
              try {
				Push.alert(notification.getData(), in, "intuit", false, deviceToken);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args){
		APNService apnService = new APNService();
		Notification notification = new Notification();
		notification.setData("hello");
		apnService.pushMessage(notification, "ca28064f0ed8ec3d40c0c44d7fd51c52c6fd532f3c46fc2d39781f825656d56c");
	}
}
