package by.learning.hospital.model.service;

import by.learning.hospital.exception.DaoException;
import by.learning.hospital.exception.ServiceException;
import by.learning.hospital.model.entity.Diagnosis;
import by.learning.hospital.model.entity.Patient;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PatientService {

    void add(int index, Patient patient) throws ServiceException;

    void delete(Patient patient) throws DaoException, ServiceException;

    void updatePatientAddressById(int id, String address) throws ServiceException;

    void updatePatientDiagnosisById(int id, Set<Diagnosis> diagnoses) throws ServiceException;

    Optional<Patient> findById(int id) throws ServiceException;

    List<Patient> findAll(Comparator<Patient> comparator) throws ServiceException;

    Optional<Integer> findPatientIndex(Patient patient) throws ServiceException;

    Optional<Patient> findByAddress(String address) throws ServiceException;

    List<Patient> findAllByMedicalCardRange(int from, int to, Comparator<Patient> comparator) throws ServiceException;
}
