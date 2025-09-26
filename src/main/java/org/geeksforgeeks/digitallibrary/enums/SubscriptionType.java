package org.geeksforgeeks.digitallibrary.enums;

public enum SubscriptionType {

    NO_SUBSCRIPTION("no_subscription"), // Can't issue book
    PLUS("plus"), // 1-3
    PRO("pro"), // 2-7
    PREMIUM("premium"); // 3-14

    private String name;

    SubscriptionType(String name){
        this.name = name;
    }
}
