package org.geeksforgeeks.digitallibrary.enums;

public enum SubscriptionType {

    NO_SUBSCRIPTION("no_subscription"),
    PLUS("plus"),
    PRO("pro"),
    PREMIUM("premium");

    private String name;

    SubscriptionType(String name){
        this.name = name;
    }
}
