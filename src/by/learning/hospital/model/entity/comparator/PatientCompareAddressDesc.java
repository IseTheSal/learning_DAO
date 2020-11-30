package by.learning.hospital.model.entity.comparator;


import by.learning.hospital.model.entity.Patient;

import java.util.Comparator;

public class PatientCompareAddressDesc implements Comparator<Patient> {

    @Override
    public int compare(Patient o1, Patient o2) {
        return o2.getAddress().compareTo(o1.getAddress());
    }
}