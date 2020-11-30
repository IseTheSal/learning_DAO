package by.learning.hospital.model.service.impl;

import by.learning.hospital.model.dao.impl.PatientDaoImpl;
import by.learning.hospital.model.dao.storage.PatientWareHouse;
import by.learning.hospital.model.entity.Patient;
import by.learning.hospital.model.entity.comparator.*;
import by.learning.hospital.model.service.PatientSortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PatientSortServiceImpl implements PatientSortService {

    private final PatientWareHouse INSTANCE_WAREHOUSE = PatientWareHouse.getInstance();
    private final PatientDaoImpl INSTANCE_PATIENT_DAO = PatientDaoImpl.getInstance();
    private List<Patient> patientList = INSTANCE_PATIENT_DAO.findAll();

    private static final Logger logger = LogManager.getLogger(PatientSortServiceImpl.class);

    @Override
    public void sortPatientByAddressAsc() {
        PatientCompareAddressAsc patientComparator = new PatientCompareAddressAsc();
        patientList.sort(patientComparator);
        int sizeList = patientList.size();
        for (int i = 0; i < sizeList; i++) {
            Patient patient = patientList.get(i);
            INSTANCE_WAREHOUSE.update(i, patient);
        }
        logger.info("List was sorted by address");
    }

    @Override
    public void sortPatientByAddressDesc() {
        PatientCompareAddressDesc patientComparator = new PatientCompareAddressDesc();
        patientList.sort(patientComparator);
        int sizeList = patientList.size();
        for (int i = 0; i < sizeList; i++) {
            Patient patient = patientList.get(i);
            INSTANCE_WAREHOUSE.update(i, patient);
        }
        logger.info("List was sorted by address");
    }


    @Override
    public void sortPatientByPhoneAsc() {
        PatientComparePhoneAsc patientComparator = new PatientComparePhoneAsc();
        patientList.sort(patientComparator);
        int sizeList = patientList.size();
        for (int i = 0; i < sizeList; i++) {
            Patient patient = patientList.get(i);
            INSTANCE_WAREHOUSE.update(i, patient);
        }
        logger.info("List was sorted by phone");
    }

    @Override
    public void sortPatientByPhoneDesc() {
        PatientComparePhoneDesc patientComparator = new PatientComparePhoneDesc();
        patientList.sort(patientComparator);
        int sizeList = patientList.size();
        for (int i = 0; i < sizeList; i++) {
            Patient patient = patientList.get(i);
            INSTANCE_WAREHOUSE.update(i, patient);
        }
        logger.info("List was sorted by phone");
    }

    @Override
    public void sortPatientBySecondNameAsc() {
        PatientCompareSecondNameAsc patientComparator = new PatientCompareSecondNameAsc();
        patientList.sort(patientComparator);
        int sizeList = patientList.size();
        for (int i = 0; i < sizeList; i++) {
            Patient patient = patientList.get(i);
            INSTANCE_WAREHOUSE.update(i, patient);
        }
        logger.info("List was sorted by name");
    }

    @Override
    public void sortPatientBySecondNameDesc() {
        PatientCompareSecondNameDesc patientComparator = new PatientCompareSecondNameDesc();
        patientList.sort(patientComparator);
        int sizeList = patientList.size();
        for (int i = 0; i < sizeList; i++) {
            Patient patient = patientList.get(i);
            INSTANCE_WAREHOUSE.update(i, patient);
        }
        logger.info("List was sorted by name");
    }

}
