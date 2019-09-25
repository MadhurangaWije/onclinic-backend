package org.kanishka.onclinicwebbackend.model.general_health_record;

import java.util.List;

public class GeneralHealthRecord {
    SurgicalHistory surgicalHistory;
    ObstetricHistory obstetricHistory;
    Allergies allergies;
    FamilyHistory familyHistory;
    Habits habits;
    List<Vaccination> vaccinations;
}
