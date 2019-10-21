package org.kanishka.onclinicwebbackend.model;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.UniqueElements;
import org.kanishka.onclinicwebbackend.model.general_health_record.GeneralHealthRecord;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Document
public class Users {

    //primary information fields
    @Id
    private ObjectId _id;

    @Indexed(unique = true)
    private String email;

    private String password;

    private String dob;


    private String firstName;

    private String lastName;

    private Gender gender;

    private boolean healthCareProfessional;

    //secondary information fields
    private String fullName;
    private String nic;
    private List<String> address=Arrays.asList("","","");
    private ContactInformation contactInformation = new ContactInformation();
    private Demographics demographics = new Demographics();

    // field assigned by the system dynamically
    private List<Roles> roles= Arrays.asList(Roles.ROLE_GENERAL);
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public GeneralHealthRecord generalHealthRecord;

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Users() {
    }

    public Users(String email, String password, String dob, String firstName, String lastName, Gender gender, boolean healthCareProfessional) {
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.healthCareProfessional = healthCareProfessional;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isHealthCareProfessional() {
        return healthCareProfessional;
    }

    public void setHealthCareProfessional(boolean healthCareProfessional) {
        this.healthCareProfessional = healthCareProfessional;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public Demographics getDemographics() {
        return demographics;
    }

    public void setDemographics(Demographics demographics) {
        this.demographics = demographics;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public GeneralHealthRecord getGeneralHealthRecord() {
        return generalHealthRecord;
    }

    public void setGeneralHealthRecord(GeneralHealthRecord generalHealthRecord) {
        this.generalHealthRecord = generalHealthRecord;
    }
}
