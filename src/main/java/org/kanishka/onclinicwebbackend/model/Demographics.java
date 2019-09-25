package org.kanishka.onclinicwebbackend.model;

import java.util.Arrays;
import java.util.List;

public class Demographics {
    private String race;
    private String religion;
    private List<String> languages= Arrays.asList("");;
    private String occupation;

    public Demographics() {
    }

    public Demographics(String race, String religion, List<String> languages, String occupation) {
        this.race = race;
        this.religion = religion;
        this.languages = languages;
        this.occupation = occupation;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
