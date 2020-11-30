package by.learning.hospital.model.dao.impl;

import by.learning.hospital.exception.*;
import by.learning.hospital.model.dao.PatientDao;
import by.learning.hospital.model.dao.storage.PatientWareHouse;
import by.learning.hospital.model.entity.Diagnosis;
import by.learning.hospital.model.entity.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class PatientDaoImpl implements PatientDao {

    private static PatientDaoImpl instance;
    private final PatientWareHouse INSTANCE = PatientWareHouse.getInstance();
    private static final Logger logger = LogManager.getLogger(PatientDaoImpl.class);


    public static synchronized PatientDaoImpl getInstance() {
        if (instance == null) {
            instance = new PatientDaoImpl();
        }
        return instance;
    }

    @Override
    public boolean contains(Patient patient) {
        List<Patient> patientList = findAll();
        boolean contains = false;
        int size = patientList.size();
        int i = 0;
        while (i < size) {
            if (patientList.get(i).equals(patient)) {
                contains = true;
                break;
            }
            i++;
        }
        return contains;
    }

    @Override
    public void add(int index, Patient patient) throws AddingException {
        if (contains(patient)) {
            throw new AddingException();
        }
        INSTANCE.add(index, patient);
    }

    @Override
    public void delete(Patient patient) throws DeletingException {
        if (!contains(patient)) {
            throw new DeletingException();
        }
        INSTANCE.remove(patient);
    }

    @Override
    public void updatePatientAddressById(int id, String address) {
        Optional<Patient> optionalPatient = findById(id);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patient.setAddress(address);
            Integer index = findPatientIndex(patient).get();
            INSTANCE.update(index, patient);
            logger.info("patient with id = " + id + " was updated");
        }
    }

    @Override
    public void updatePatientDiagnosisById(int id, Set<Diagnosis> diagnoses) {
        Optional<Patient> optionalPatient = findById(id);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patient.setDiagnoses(diagnoses);
            Integer index = findPatientIndex(patient).get();
            INSTANCE.update(index, patient);
            logger.info("patient with id = " + id + " was updated");
        }
    }

    @Override
    public Optional<Patient> findById(int id) {
        Optional<Patient> result = Optional.empty();
        List<Patient> patientList = findAll();
        int size = patientList.size();
        int i = 0;
        while (i < size) {
            if (patientList.get(i).getId() == id) {
                result = Optional.of(patientList.get(i));
                break;
            }
            i++;
        }
        return result;
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> result = new ArrayList<>();
        int size = INSTANCE.size();
        for (int i = 0; i < size; i++) {
            result.add(INSTANCE.get(i));
        }
        return result;
    }

    @Override
    public Optional<Integer> findPatientIndex(Patient patient) {
        List<Patient> patientList = findAll();
        Optional<Integer> index = Optional.empty();
        int size = patientList.size();
        int i = 0;
        while (i < size) {
            if (patientList.get(i).equals(patient)) {
                index = Optional.of(i);
                break;
            }
            i++;
        }
        return index;
    }

    @Override
    public Optional<Patient> findByAddress(String address) {
        Optional<Patient> result = Optional.empty();
        List<Patient> patientList = findAll();
        int size = patientList.size();
        int i = 0;
        while (i < size) {
            if (patientList.get(i).getAddress().equalsIgnoreCase(address)) {
                result = Optional.of(patientList.get(i));
                break;
            }
            i++;
        }
        return result;
    }

    @Override
    public List<Patient> findAllByMedicalCardRange(int from, int to) {
        List<Patient> resultList = new ArrayList<>();
        List<Patient> patientList = findAll();
        for (Patient patient : patientList) {
            int medicalCard = patient.getMedicalCardId();
            if ((medicalCard >= from) && (medicalCard <= to)) {
                resultList.add(patient);
            }
        }
        return resultList;
    }
}
