package org.kanishka.onclinicwebbackend.model.general_health_record;

public class ObstetricHistory {
    private String pregnantDate;
    private String deliveryDate;
    private String complications;
    private String outcomes;

    public ObstetricHistory() {
    }

    public String getPregnantDate() {
        return pregnantDate;
    }

    public void setPregnantDate(String pregnantDate) {
        this.pregnantDate = pregnantDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getComplications() {
        return complications;
    }

    public void setComplications(String complications) {
        this.complications = complications;
    }

    public String getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(String outcomes) {
        this.outcomes = outcomes;
    }
}
