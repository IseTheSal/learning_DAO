package by.learning.hospital.model.dao.storage;

import by.learning.hospital.model.entity.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientWareHouse {

    private static PatientWareHouse instance;
    private List<Patient> patientList = new ArrayList<>();

    public static synchronized PatientWareHouse getInstance() {
        if (instance == null) {
            instance = new PatientWareHouse();
        }
        return instance;
    }

    public void add(int index, Patient patient) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        patientList.add(index, patient);
    }

    public void add(Patient patient) {
        patientList.add(patient);
    }

    public Patient get(int index) {
        if (index < 0 || index > patientList.size()) {
            throw new IndexOutOfBoundsException();
        }
        return patientList.get(index);
    }

    public void update(int index, Patient patient) {
        if (index >= patientList.size()) {
            throw new IndexOutOfBoundsException();
        }
        patientList.remove(index);
        patientList.add(index, patient);
    }

    public void remove(Patient patient) {
        patientList.remove(patient);
    }

    public int size() {
        return patientList.size();
    }


}
