package org.example;

import java.util.ArrayList;

public class Visitor {
    private String name;
    private int age;
    private String phoneNumber;
    private double balance;
    private String email;
    private String password;
    private Membership membership;
    private int tickets;
    private double cost;
    private static ArrayList visitors = new ArrayList<>();
    private static ArrayList<Integer> visitorattractionticket = new ArrayList<Integer>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public static void setVisitors(ArrayList<Visitor> visitors) {
        Visitor.visitors = visitors;
    }
    public static ArrayList<Visitor> getVisitors() {
        return visitors;
    }
    public static ArrayList<Integer> getVisitorattractionticket() {
        return visitorattractionticket;
    }
    public static void setVisitorattractionticket(ArrayList<Integer> visitorattractionticket) {
        Visitor.visitorattractionticket = visitorattractionticket;
    }
    public Membership getMembership() {
        return membership;
    }
    public void setMembership(Membership membership) {
        this.membership = membership;
    }
    public int getTickets() {
        return tickets;
    }
    public void setTickets(int tickets) {
        this.tickets = tickets;
    }
    public static ArrayList<Visitor> visitors() {
        return visitors;
    }
    public static void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }
    public static void addVisitorAttractionTicket(int attractionId, int numberOfTickets) {
        for (int i = 0; i < numberOfTickets; i++) {
            visitorattractionticket.add(attractionId);
        }
    }
    public boolean hasTicketForAttraction(int attractionId) {
        return visitorattractionticket.contains(attractionId);
    }
    //remove the ticket which are already in visitors ArrayList, after visitor visits the attractions
    public void removeVisitorAttractionTicket(int attractionId) {
        if (hasTicketForAttraction(attractionId)) {
            visitorattractionticket.remove(Integer.valueOf(attractionId));
        }
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    public Visitor(String name, int age, String phoneNumber, double balance, String email, String password, Membership membership) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.membership = membership;
        this.tickets = 0;
    }
}