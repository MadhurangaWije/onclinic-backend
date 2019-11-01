package org.kanishka.onclinicwebbackend.model.reports;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "reports")
public class Report<T> {

    @Id
    private String _id;

    private String userId;
    private String type;
    private T eRecord;
    private List<StaticResource> resources;
    private String extraNotes;
    private String publishedByUserId;
    private String date;

    public Report() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T geteRecord() {
        return eRecord;
    }

    public void seteRecord(T eRecord) {
        this.eRecord = eRecord;
    }

    public List<StaticResource> getResources() {
        return resources;
    }

    public void setResources(List<StaticResource> resources) {
        this.resources = resources;
    }

    public String getExtraNotes() {
        return extraNotes;
    }

    public void setExtraNotes(String extraNotes) {
        this.extraNotes = extraNotes;
    }

    public String getPublishedByUserId() {
        return publishedByUserId;
    }

    public void setPublishedByUserId(String publishedByUserId) {
        this.publishedByUserId = publishedByUserId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
