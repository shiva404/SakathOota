/**
 * 
 */
package com.sakathOota.tests;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.testng.annotations.Test;

import com.sakathOota.tests.commons.TestBase;
import com.sun.jersey.api.client.ClientResponse;
import com.whiteSpace.resource.json.types.Entry;
import com.whiteSpace.resource.json.types.FBNotification;

/**
 * @author Shivakumar N
 *
 * @since Jan 9, 2013 11:00:30 PM
 */
public class FBNotificationsTest extends TestBase{

	@Test
	public void getCallTest(){
		resource.path("fb").queryParam("hub.mode", "abc").
		queryParam("hub.verify_token", "xyz").queryParam("hub.challenge", "pqr").get(ClientResponse.class);
	}
	
	@Test
	public void postCallTest(){
		FBNotification fbNotification = new FBNotification();
		Entry entry = new Entry();
		entry.setId(100001609165007L);
		entry.setUid(100001609165007L);
		List<String> changedFileds =  new ArrayList<String>();
		changedFileds.add("checkins");
		entry.setChanged_fields(changedFileds);
		fbNotification.getEntry().add(entry);
		resource.path("fb").accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).entity(fbNotification).post();
		
	}
	
	@Test
	public void pnTest(){
		resource.path("pn/1").get(ClientResponse.class);
		
	}
	
}
