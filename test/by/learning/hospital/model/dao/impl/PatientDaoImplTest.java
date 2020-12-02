package by.learning.hospital.model.dao.impl;

import by.learning.hospital.exception.DaoException;
import by.learning.hospital.model.entity.Diagnosis;
import by.learning.hospital.model.entity.Patient;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class PatientDaoImplTest {

    PatientDaoImpl patientDao;
    Patient patient;
    int id = 0;
    Patient patient2;
    int id2;

    @BeforeClass
    public void init() {
        patientDao = PatientDaoImpl.getWareHouse();
        patient = new Patient();
    }

    @BeforeMethod(onlyForGroups = "findAll")
    public void initPatient2() {
        patient2 = new Patient();
    }

    @Test
    public void testContains() {
        boolean condition = false;
        try {
            patientDao.add(id, patient);
            condition = patientDao.contains(patient);
        } catch (DaoException e) {
            Assert.fail();
        }
        Assert.assertTrue(condition);
    }

    @Test
    public void testAdd() {
        try {
            patientDao.add(id, patient);
        } catch (DaoException e) {
            Assert.fail();
        }
    }

    @Test
    public void testDelete() {
        try {
            patientDao.add(id, patient);
            patientDao.delete(patient);
        } catch (DaoException e) {
            Assert.fail();
        }
    }

    @Test(groups = "patient")
    public void testUpdatePatientDiagnosisById() {
        Set<Diagnosis> actual = EnumSet.of(Diagnosis.ALLERGIC_RHINITIS, Diagnosis.ANXIETY);
        try {
            patientDao.add(id, patient);
            patientDao.updatePatientDiagnosisById(0, actual);
        } catch (DaoException e) {
            Assert.fail();
        }
        Set<Diagnosis> expected = patient.getDiagnoses();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindById() {
        boolean condition = false;
        try {
            patientDao.add(id, patient);
            condition = patientDao.findById(id).isPresent();
        } catch (DaoException e) {
            Assert.fail();
        }
        Assert.assertTrue(condition);
    }

    @Test
    public void testFindAll() {
        boolean condition = true;
        try {
            patientDao.add(id, patient);
            condition = patientDao.findAll().isEmpty();
        } catch (DaoException e) {
            Assert.fail();
        }
        Assert.assertFalse(condition);
    }

    @Test
    public void testFindPatientIndex() {
        Integer actual = null;
        try {
            patientDao.add(id, patient);
            if (patientDao.findPatientIndex(patient).isPresent()) {
                actual = patientDao.findPatientIndex(patient).get();
            }
        } catch (DaoException e) {
            Assert.fail();
        }
        Integer expected = 0;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindByAddress() {
        String address = "Novay 9";
        patient.setAddress(address);
        Patient actual = null;
        try {
            patientDao.add(id, patient);
            if (patientDao.findByAddress(address).isPresent()) {
                actual = patientDao.findByAddress(address).get();
            }
        } catch (DaoException e) {
            Assert.fail();
        }
        Patient expected = patient;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = "findAll")
    public void testFindAllByMedicalCardRange() {
        List<Patient> actual = new ArrayList<>();
        try {
            patientDao.add(id, patient);
            patientDao.add(id2, patient2);
            actual = patientDao.findAllByMedicalCardRange(0, 1);
        } catch (DaoException e) {
            Assert.fail();
        }
        List<Patient> expected = new ArrayList<>();
        expected.add(patient2);
        expected.add(patient);
        Assert.assertEquals(actual, expected);
    }

    @AfterMethod(onlyForGroups = "findAll")
    public void deletePatient2() {
        try {
            patientDao.delete(patient2);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void deletePatient() {
        try {
            patientDao.delete(patient);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}