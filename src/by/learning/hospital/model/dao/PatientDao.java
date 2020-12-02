package by.learning.hospital.model.dao;


import by.learning.hospital.exception.AddingException;
import by.learning.hospital.exception.DeletingException;
import by.learning.hospital.model.entity.Diagnosis;
import by.learning.hospital.model.entity.Patient;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PatientDao {

    boolean contains(Patient patient);

    void add(int index, Patient patient) throws AddingException;

    void delete(Patient patient) throws DeletingException;

    void updatePatientAddressById(int id, String address);

    void updatePatientDiagnosisById(int id, Set<Diagnosis> diagnoses);

    Optional<Patient> findById(int id);

    List<Patient> findAll();

    Optional<Integer> findPatientIndex(Patient patient);

    Optional<Patient> findByAddress(String address);

    List<Patient> findAllByMedicalCardRange(int from, int to);

}
