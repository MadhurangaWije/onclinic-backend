package org.kanishka.onclinicwebbackend.model.reports;

import java.util.List;

public class DischargeRecord {
    String hospital;
    String admittedOn;
    String bht;
    String ward;
    String complain;
    String treatment;
    List<String> investigations;
    String diagnosis;
    List<String> prescribedDrugs;
    String remarks;

    public DischargeRecord() {
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getAdmittedOn() {
        return admittedOn;
    }

    public void setAdmittedOn(String admittedOn) {
        this.admittedOn = admittedOn;
    }

    public String getBht() {
        return bht;
    }

    public void setBht(String bht) {
        this.bht = bht;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getComplain() {
        return complain;
    }

    public void setComplain(String complain) {
        this.complain = complain;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public List<String> getInvestigations() {
        return investigations;
    }

    public void setInvestigations(List<String> investigations) {
        this.investigations = investigations;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public List<String> getPrescribedDrugs() {
        return prescribedDrugs;
    }

    public void setPrescribedDrugs(List<String> prescribedDrugs) {
        this.prescribedDrugs = prescribedDrugs;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
