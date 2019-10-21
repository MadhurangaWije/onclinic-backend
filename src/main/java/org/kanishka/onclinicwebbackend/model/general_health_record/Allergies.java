package org.kanishka.onclinicwebbackend.model.general_health_record;

import java.util.List;

public class Allergies {
    private List<String> medical;
    private List<String> nonMedical;

    public Allergies() {
    }

    public List<String> getMedical() {
        return medical;
    }

    public void setMedical(List<String> medical) {
        this.medical = medical;
    }

    public List<String> getNonMedical() {
        return nonMedical;
    }

    public void setNonMedical(List<String> nonMedical) {
        this.nonMedical = nonMedical;
    }
}
