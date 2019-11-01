package org.kanishka.onclinicwebbackend.model;

public class TimeSlot {
    private String day;
    private TimePeriod timePeriod;

    public TimeSlot() {
    }

    public TimeSlot(String day, TimePeriod timePeriod) {
        this.day = day;
        this.timePeriod = timePeriod;
    }

    public static TimeSlot getInstance(String day, String from, String to) {
        TimePeriod timePeriod=new TimePeriod(from,to);
        return new TimeSlot(day, timePeriod);
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public TimePeriod getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(TimePeriod timePeriod) {
        this.timePeriod = timePeriod;
    }
}
