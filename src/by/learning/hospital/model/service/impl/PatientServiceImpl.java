package by.learning.hospital.model.service.impl;

import by.learning.hospital.exception.DaoException;
import by.learning.hospital.exception.ServiceException;
import by.learning.hospital.model.dao.impl.PatientDaoImpl;
import by.learning.hospital.model.entity.Diagnosis;
import by.learning.hospital.model.entity.Patient;
import by.learning.hospital.model.service.PatientService;
import by.learning.hospital.validator.PatientValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class PatientServiceImpl implements PatientService {
    private static final Logger logger = LogManager.getLogger(PatientServiceImpl.class);

    private static final PatientDaoImpl PATIENT_DAO = PatientDaoImpl.getWareHouse();

    @Override
    public void add(int index, Patient patient) throws ServiceException {
        if (patient == null) {
            throw new ServiceException("Patient is null");
        }
        if (!PatientValidator.isNameValid(patient.getFirstName())) {
            throw new ServiceException("Patient name is incorrect");
        }
        if (!PatientValidator.isNameValid(patient.getSecondName())) {
            throw new ServiceException("Patient second name is incorrect");
        }
        if (!PatientValidator.isNameValid(patient.getPatronymic())) {
            throw new ServiceException("Patient patronymic is incorrect");
        }
        if (!PatientValidator.isPhoneValid(patient.getPhoneNumber())) {
            throw new ServiceException("Patient phone is incorrect");
        }
        try {
            PATIENT_DAO.add(index, patient);
            logger.info("Patient - {} was added", patient);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Patient patient) throws ServiceException {
        try {
            PATIENT_DAO.delete(patient);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updatePatientAddressById(int id, String address) throws ServiceException {
        try {
            PATIENT_DAO.updatePatientAddressById(id, address);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updatePatientDiagnosisById(int id, Set<Diagnosis> diagnoses) throws ServiceException {
        try {
            PATIENT_DAO.updatePatientDiagnosisById(id, diagnoses);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Patient> findById(int id) throws ServiceException {
        Optional<Patient> result;
        try {
            result = PATIENT_DAO.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public List<Patient> findAll(Comparator<Patient> comparator) throws ServiceException {
        List<Patient> result;
        try {
            result = PATIENT_DAO.findAll();
            result.sort(comparator);
        } catch (DaoException e) {
            throw new ServiceException();
        }
        return result;
    }

    @Override
    public Optional<Integer> findPatientIndex(Patient patient) throws ServiceException {
        Optional<Integer> result;
        if (patient == null) {
            throw new ServiceException("Patient is null");
        }
        try {
            result = PATIENT_DAO.findPatientIndex(patient);
            logger.info("Patient was founded");
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public Optional<Patient> findByAddress(String address) throws ServiceException {
        Optional<Patient> result;
        try {
            result = PATIENT_DAO.findByAddress(address);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public List<Patient> findAllByMedicalCardRange(int from, int to, Comparator<Patient> comparator) throws ServiceException {
        List<Patient> result;
        try {
            result = PATIENT_DAO.findAllByMedicalCardRange(from, to);
            result.sort(comparator);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return result;
    }
}
