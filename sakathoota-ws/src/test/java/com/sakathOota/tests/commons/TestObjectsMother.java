package com.sakathOota.tests.commons;

import com.whiteSpace.domain.common.types.FoodPreference;
import com.whiteSpace.domain.common.types.Gender;
import com.whiteSpace.domain.common.types.User;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 1/20/13
 * Time: 9:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestObjectsMother {

    public static User getNewUserTestObject(){
        User user = new User();
        String sysTime = "" + System.currentTimeMillis();
        user.setEmail("something"+ sysTime +"@nothing.com");
        user.setDateOfBirth(new Date());
        user.setFacebookId(1234L);
        user.setFoodPref(FoodPreference.NON_VEG);
        user.setName("something" + sysTime);
        user.setGender(Gender.MALE);
        return user;
    }
}
