package org.kanishka.onclinicwebbackend.model.reports;

import java.util.List;

public abstract class Report<T> {
    String _id;
    String userId;
    T eRecord;
    List<StaticResource> resources;
    String extraNotes;
    String publishedByUserId;
    String date;
}
