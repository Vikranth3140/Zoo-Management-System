package org.example;

public abstract class Attraction extends Zoo implements Availability{
    private int attractionID;
    private String name;
    private String description;
    private double ticketPrice;
    private boolean available;
    private int visitorCount;
    private Availability availability = new AttractionAvailability();
    public int getAttractionID() {
        return attractionID;
    }

    public void setAttractionID(int attractionID) {
        this.attractionID = attractionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getVisitorCount() {
        return visitorCount;
    }

    public void setVisitorCount(int visitorCount) {
        this.visitorCount = visitorCount;
    }

    //increase visitor count by 1
    public void increaseVisitorCount() {
        visitorCount++;
    }

    //return if availability status of the attraction
    public boolean isOpen() {
        return availability.isOpen();
    }

    //set the attraction open
    public void setOpen(boolean open) {
        availability.setOpen(open);
    }

    //to be overridden everytime I make an object of attraction class
    public abstract void welcomeMessage();
}