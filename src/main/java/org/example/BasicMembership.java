package org.example;

public class BasicMembership implements Membership {
    public static double getMembershipCost;

    //gets the membership cost of Basic Member
    @Override
    public double getMembershipCost() {
        return 20.0;
    }

    //gets the membership type of Basic Member
    @Override
    public String getMembershipType() {
        return "Basic";
    }
}