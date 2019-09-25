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
}
