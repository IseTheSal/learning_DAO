package by.learning.hospital.model.entity;

import by.learning.hospital.util.IdGenerator;

import java.util.EnumSet;
import java.util.Set;

public class Patient {

    private long id = IdGenerator.getCurrentId();
    private String firstName;
    private String secondName;
    private String patronymic;
    private String address;
    private String phoneNumber;
    private long medicalCardId = IdGenerator.getCurrentMedicalCardId();
    private Set<Diagnosis> diagnoses = EnumSet.noneOf(Diagnosis.class);

    public Patient() {
    }

    public Patient(String firstName, String secondName, String patronymic, String address, String phoneNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Patient(String firstName, String secondName, String patronymic, String address, String phoneNumber, Set<Diagnosis> diagnoses) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.diagnoses = diagnoses;
    }

    public long getId() {
        return id;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getMedicalCardId() {
        return medicalCardId;
    }

    public void setMedicalCardId(int medicalCardId) {
        this.medicalCardId = medicalCardId;
    }

    public Set<Diagnosis> getDiagnoses() {
        return EnumSet.copyOf(this.diagnoses);
    }

    public void addDiagnose(Diagnosis diagnose) {
        diagnoses.add(diagnose);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (id != patient.id) return false;
        if (medicalCardId != patient.medicalCardId) return false;
        if (firstName != null ? !firstName.equals(patient.firstName) : patient.firstName != null) return false;
        if (secondName != null ? !secondName.equals(patient.secondName) : patient.secondName != null) return false;
        if (patronymic != null ? !patronymic.equals(patient.patronymic) : patient.patronymic != null) return false;
        if (address != null ? !address.equals(patient.address) : patient.address != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(patient.phoneNumber) : patient.phoneNumber != null) return false;
        return diagnoses != null ? diagnoses.equals(patient.diagnoses) : patient.diagnoses == null;
    }


    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (int) (medicalCardId ^ (medicalCardId >>> 32));
        result = 31 * result + (diagnoses != null ? diagnoses.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Patient{");
        sb.append("Id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", secondName='").append(secondName).append('\'');
        sb.append(", patronymic='").append(patronymic).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", medicalCardId=").append(medicalCardId);
        sb.append(", diagnoses=").append(diagnoses);
        sb.append('}');
        return sb.toString();
    }
}
