/**
 * 
 */
package com.whiteSpace.domain.common.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Shivakumar N
 *
 * @since Feb 3, 2013 7:20:31 PM
 */
@XmlType(name="FoodType")
@XmlEnum
public enum FoodType {
    NOT_SPECIFIED(0),
    VEG(1),
    NON_VEG(2),
    VEG_EGG(3);

    private int value;
    
    public static FoodType forCode(int code) {
        for (FoodType type : FoodType.values()) {
            if (type.getValue() == code) {
                return type;
            }
        }
        return null;
     }

    private FoodType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
