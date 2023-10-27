package org.example;

public class AttractionAvailability implements Availability {
    //scheduling default available attraction to be open
    private boolean isOpen = false;

    //return true to set it open
    @Override
    public boolean isOpen() {
        return isOpen;
    }

    //set it open
    @Override
    public void setOpen(boolean open) {
        isOpen = open;
    }
}