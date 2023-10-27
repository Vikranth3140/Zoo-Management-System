package org.example;

public class PremiumMembership implements Membership {
    public static double getMembershipCost;

    //gets the membership cost of Premium Member
    @Override
    public double getMembershipCost() {
        return 50.0;
    }

    //gets the membership type of Premium Member
    @Override
    public String getMembershipType() {
        return "Premium";
    }
}