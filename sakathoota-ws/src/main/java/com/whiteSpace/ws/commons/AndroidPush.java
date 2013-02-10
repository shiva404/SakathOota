/**
 * 
 */
package com.whiteSpace.ws.commons;

import java.io.DataInputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.whiteSpace.domain.common.types.Notification;

/**
 * @author Shivakumar N
 * 
 * @since Feb 10, 2013 7:45:39 PM
 */
public class AndroidPush {
	private static final String url = "http://mobile-prototype.intuitlabs.com/devicereg/api/gcm/projects/";
	private static final String projectId = "718563600015";
	private static final String url_postfix = "/devices/notifications";

	public void processRequest(Notification notification) throws Exception {

		String pushUrl = url + projectId + url_postfix;
		HttpURLConnection conn = (HttpURLConnection) new URL(pushUrl)
				.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoInput(true);
		conn.setRequestProperty("Content-Type", "text/plain");
		conn.setDoOutput(true);
		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

		wr.write(notification.getData());
		wr.flush();

		DataInputStream input = new DataInputStream(conn.getInputStream());
		String str;
		while (null != ((str = input.readLine()))) {
			System.out.println(str);
		}
		input.close();
	}
	public static void main(String[] args) {
		AndroidPush androidPush = new AndroidPush();
		Notification notification = new Notification();
		notification.setData("huhha haaha .. i can hack into ur mobile :P ");
		try {
			androidPush.processRequest(notification);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
