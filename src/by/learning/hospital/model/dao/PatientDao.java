package by.learning.hospital.model.dao;


import by.learning.hospital.exception.DaoException;
import by.learning.hospital.model.entity.Diagnosis;
import by.learning.hospital.model.entity.Patient;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PatientDao {

    boolean contains(Patient patient) throws DaoException;

    void add(int index, Patient patient) throws DaoException;

    void delete(Patient patient) throws DaoException;

    void updatePatientAddressById(int id, String address) throws DaoException;

    void updatePatientDiagnosisById(int id, Set<Diagnosis> diagnoses) throws DaoException;

    Optional<Patient> findById(int id) throws DaoException;

    List<Patient> findAll() throws DaoException;

    Optional<Integer> findPatientIndex(Patient patient) throws DaoException;

    Optional<Patient> findByAddress(String address) throws DaoException;

    List<Patient> findAllByMedicalCardRange(int from, int to) throws DaoException;
}
