package org.kanishka.onclinicwebbackend.model;

public class TimePeriod {
    private String from;
    private String to;

    public TimePeriod() {
    }

    public TimePeriod(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
