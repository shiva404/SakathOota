package com.whiteSpace.domain.common.types;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 1/20/13
 * Time: 8:59 PM
 * To change this template use File | Settings | File Templates.
 */
public enum FoodPreference {
    NOT_SPECIFIED(0),
    VEG(1),
    NON_VEG(2),
    VEG_EGG(3);

    private int value;

    private FoodPreference(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
