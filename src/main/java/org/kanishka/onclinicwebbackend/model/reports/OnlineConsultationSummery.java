package org.kanishka.onclinicwebbackend.model.reports;

public class OnlineConsultationSummery {
    private String query;
    private String consultationSummery;
    private String startedAt;
    private String duration;
    private Media media;
    private String remarks;

    public OnlineConsultationSummery() {
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getConsultationSummery() {
        return consultationSummery;
    }

    public void setConsultationSummery(String consultationSummery) {
        this.consultationSummery = consultationSummery;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
