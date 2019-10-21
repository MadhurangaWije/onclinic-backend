package org.kanishka.onclinicwebbackend.model.general_health_record;

import java.util.List;

public class GeneralHealthRecord {

    private List<SurgicalHistory> surgicalHistory;
    private List<ObstetricHistory> obstetricHistory;
    private Allergies allergies;
    private FamilyHistory familyHistory;
    private Habits habits;
    private List<Vaccination> vaccinations;

    public GeneralHealthRecord() {
    }

    public List<SurgicalHistory> getSurgicalHistory() {
        return surgicalHistory;
    }

    public void setSurgicalHistory(List<SurgicalHistory> surgicalHistory) {
        this.surgicalHistory = surgicalHistory;
    }

    public List<ObstetricHistory> getObstetricHistory() {
        return obstetricHistory;
    }

    public void setObstetricHistory(List<ObstetricHistory> obstetricHistory) {
        this.obstetricHistory = obstetricHistory;
    }

    public Allergies getAllergies() {
        return allergies;
    }

    public void setAllergies(Allergies allergies) {
        this.allergies = allergies;
    }

    public FamilyHistory getFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(FamilyHistory familyHistory) {
        this.familyHistory = familyHistory;
    }

    public Habits getHabits() {
        return habits;
    }

    public void setHabits(Habits habits) {
        this.habits = habits;
    }

    public List<Vaccination> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(List<Vaccination> vaccinations) {
        this.vaccinations = vaccinations;
    }
}
