package org.kanishka.onclinicwebbackend.model;

import java.util.Arrays;
import java.util.List;

public class ContactInformation {
    private List<String> personal= Arrays.asList("");
    private List<String> emergency= Arrays.asList("");;

    public ContactInformation() {
    }

    public ContactInformation(List<String> personal, List<String> emergency) {
        this.personal = personal;
        this.emergency = emergency;
    }

    public List<String> getPersonal() {
        return personal;
    }

    public void setPersonal(List<String> personal) {
        this.personal = personal;
    }

    public List<String> getEmergency() {
        return emergency;
    }

    public void setEmergency(List<String> emergency) {
        this.emergency = emergency;
    }
}
