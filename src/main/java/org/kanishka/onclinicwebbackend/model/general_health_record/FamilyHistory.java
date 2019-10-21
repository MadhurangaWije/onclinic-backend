package org.kanishka.onclinicwebbackend.model.general_health_record;

import java.util.List;

public class FamilyHistory {
    private String healthSummery;
    private List<String> commonFamilyDiseases;

    public FamilyHistory() {
    }

    public String getHealthSummery() {
        return healthSummery;
    }

    public void setHealthSummery(String healthSummery) {
        this.healthSummery = healthSummery;
    }

    public List<String> getCommonFamilyDiseases() {
        return commonFamilyDiseases;
    }

    public void setCommonFamilyDiseases(List<String> commonFamilyDiseases) {
        this.commonFamilyDiseases = commonFamilyDiseases;
    }
}
