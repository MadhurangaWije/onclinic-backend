package org.kanishka.onclinicwebbackend.model.general_health_record;

import org.kanishka.onclinicwebbackend.model.reports.StaticResource;

import java.util.List;

public class SurgicalHistory {
    private String subject;
    private String summery;
    private String date;
    private List<StaticResource> resources;

    public SurgicalHistory() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSummery() {
        return summery;
    }

    public void setSummery(String summery) {
        this.summery = summery;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StaticResource> getResources() {
        return resources;
    }

    public void setResources(List<StaticResource> resources) {
        this.resources = resources;
    }
}
