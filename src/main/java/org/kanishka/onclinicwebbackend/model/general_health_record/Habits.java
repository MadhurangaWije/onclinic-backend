package org.kanishka.onclinicwebbackend.model.general_health_record;

public class Habits {
    private String smoking;
    private String alcoholConsumption;
    private String exercises;
    private String diet;
    private String sexualHistory;
    private String other;

    public Habits() {
    }

    public String getSmoking() {
        return smoking;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }

    public String getAlcoholConsumption() {
        return alcoholConsumption;
    }

    public void setAlcoholConsumption(String alcoholConsumption) {
        this.alcoholConsumption = alcoholConsumption;
    }

    public String getExercises() {
        return exercises;
    }

    public void setExercises(String exercises) {
        this.exercises = exercises;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getSexualHistory() {
        return sexualHistory;
    }

    public void setSexualHistory(String sexualHistory) {
        this.sexualHistory = sexualHistory;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
