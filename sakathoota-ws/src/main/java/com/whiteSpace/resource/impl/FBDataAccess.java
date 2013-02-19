/**
 * 
 */
package com.whiteSpace.resource.impl;

import java.sql.Connection;
import java.util.List;

import org.springframework.social.connect.ConnectionData;
import org.springframework.social.facebook.api.Checkin;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @author Shivakumar N
 * 
 * @since Jan 22, 2013 4:42:50 PM
 */
public class FBDataAccess {
	private FacebookConnectionFactory connectionFactory;

	public FacebookConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}

	public void setConnectionFactory(FacebookConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	public List<Checkin> getUserCheckins(String accessToken) {
		Facebook facebook = connectionFactory.createConnection(new AccessGrant(accessToken)).getApi();
		List<Checkin> checkins = facebook.placesOperations().getCheckins();
		return checkins;
	}
	
	
	
	public void writeCheckinToFb(String accessToken) {
		Facebook facebook = connectionFactory.createConnection(new AccessGrant(accessToken)).getApi();
		//facebook.pageOperations().post("326435557475012", "Shiva rated Biriyani @Meghana");
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.set("link", "http://shivus-drawings.blogspot.com/");
		map.set("name", "Soemthing");
		map.set("caption", "Link Caption");
		map.set("description", "Something @nothing");
		map.set("message", "Something got rated @something");

		// THE BELOW LINES ARE THE CRITICAL PART I WAS LOOKING AT!
		map.set("picture", "http://1.bp.blogspot.com/-ebMeo13zhHk/TiJ6nQlXUqI/AAAAAAAAAAg/uLJ3mM0IEy8/s220/258295_1659810830149_1683517251_1208344_4593680_o.jpg"); // the image on the left
		map.set("actions", "{'name':'myAction', 'link':'http://shivus-drawings.blogspot.com/'}"); // custom actions as JSON string
		//FIXME: Remove hard coded values
		facebook.publish("326435557475012", "feed", map);
	}
	
	public void writeFeedItemToFB(String accessToken, String link, String name, String caption, String description, String message, String picture, String actions){
		Facebook facebook = connectionFactory.createConnection(new AccessGrant(accessToken)).getApi();
		
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		if(link != null)
		map.set("link", link);
		if(name != null)
		map.set("name", name);
		if(caption != null)
		map.set("caption", caption);
		if(description != null)
		map.set("description", description);
		if(message != null)
		map.set("message", message);

		// THE BELOW LINES ARE THE CRITICAL PART I WAS LOOKING AT!
		if(picture != null)
		map.set("picture", picture); // the image on the left
		if(actions != null)
		map.set("actions", actions);
	
		facebook.publish("326435557475012", "feed", map);
	}
}
