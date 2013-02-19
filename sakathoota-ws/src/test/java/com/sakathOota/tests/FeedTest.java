/**
 * 
 */
package com.sakathOota.tests;


import org.testng.annotations.Test;

import com.sakathOota.tests.commons.TestBase;
import com.sakathOota.tests.commons.TestObjectsMother;

/**
 * @author Shivakumar N
 *
 * @since Feb 19, 2013 8:53:04 AM
 */
public class FeedTest extends TestBase{
	
	@Test
	public void newFeedItem(){
		resource.path("feed").entity(TestObjectsMother.getFeedItem()).post();
	}

}
