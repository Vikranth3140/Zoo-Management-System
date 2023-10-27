package org.example;

public class Feedback {
    private String visitorName;
    private String feedback;
    public String getVisitorName() {
        return visitorName;
    }
    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }
    public String getFeedback() {
        return feedback;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    public Feedback(String visitorName, String feedback) {
        this.visitorName = visitorName;
        this.feedback = feedback;
    }
}