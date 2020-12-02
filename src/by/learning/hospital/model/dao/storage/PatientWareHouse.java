package by.learning.hospital.model.dao.storage;

import by.learning.hospital.exception.DaoException;
import by.learning.hospital.model.entity.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientWareHouse {

    private static PatientWareHouse instance;
    private List<Patient> patientList = new ArrayList<>();

    public static PatientWareHouse getInstance() {
        if (instance == null) {
            instance = new PatientWareHouse();
        }
        return instance;
    }

    public void add(int index, Patient patient) throws DaoException {
        if (index < 0) {
            throw new DaoException("Index " + index + " is less than 0");
        }
        patientList.add(index, patient);
    }

    public void add(Patient patient) {
        patientList.add(patient);
    }

    public Patient get(int index) throws DaoException {
        if (index < 0 || index >= patientList.size()) {
            throw new DaoException("Index - " + index + " goes out of List");
        }
        return patientList.get(index);
    }

    public void update(int index, Patient patient) throws DaoException {
        if (index < 0 || index >= patientList.size()) {
            throw new DaoException("Index - " + index + " goes out of List");
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
