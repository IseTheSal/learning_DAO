package by.learning.hospital.model.dao.impl;

import by.learning.hospital.model.entity.Diagnosis;
import by.learning.hospital.model.entity.Patient;
import by.learning.hospital.model.exception.AddingException;
import by.learning.hospital.model.exception.DeletingException;
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
        patientDao = PatientDaoImpl.getInstance();
        patient = new Patient();
    }

    @BeforeMethod(onlyForGroups = "findAll")
    public void initPatient2() {
        patient2 = new Patient();
    }

    @Test
    public void testContains() {
        try {
            patientDao.add(id, patient);
        } catch (AddingException e) {
            Assert.fail();
        }
        boolean condition = patientDao.contains(patient);
        Assert.assertTrue(condition);
    }

    @Test
    public void testAdd() {
        try {
            patientDao.add(id, patient);
        } catch (AddingException e) {
            Assert.fail();
        }
    }

    @Test
    public void testDelete() {
        try {
            patientDao.add(id, patient);
            patientDao.delete(patient);
        } catch (DeletingException | AddingException e) {
            Assert.fail();
        }
    }

    @Test(groups = "patient")
    public void testUpdatePatientDiagnosisById() {
        try {
            patientDao.add(id, patient);
        } catch (AddingException e) {
            Assert.fail();
        }
        Set<Diagnosis> actual = EnumSet.of(Diagnosis.ALLERGIC_RHINITIS, Diagnosis.ANXIETY);
        patientDao.updatePatientDiagnosisById(0, actual);
        Set<Diagnosis> expected = patient.getDiagnoses();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindById() {
        try {
            patientDao.add(id, patient);
        } catch (AddingException e) {
            Assert.fail();
        }
        boolean condition = patientDao.findById(id).isPresent();
        Assert.assertTrue(condition);
    }

    @Test
    public void testFindAll() {
        try {
            patientDao.add(id, patient);
        } catch (AddingException e) {
            Assert.fail();
        }
        boolean condition = patientDao.findAll().isEmpty();
        Assert.assertFalse(condition);
    }

    @Test
    public void testFindPatientIndex() {
        try {
            patientDao.add(id, patient);
        } catch (AddingException e) {
            Assert.fail();
        }
        Integer actual = null;
        if (patientDao.findPatientIndex(patient).isPresent()) {
            actual = patientDao.findPatientIndex(patient).get();
        }
        Integer expected = 0;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindByAddress() {
        String address = "Novay 9";
        patient.setAddress(address);
        try {
            patientDao.add(id, patient);
        } catch (AddingException e) {
            Assert.fail();
        }
        Patient actual = null;
        if (patientDao.findByAddress(address).isPresent()) {
            actual = patientDao.findByAddress(address).get();
        }
        Patient expected = patient;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = "findAll")
    public void testFindAllByMedicalCardRange() {
        try {
            patientDao.add(id, patient);
            patientDao.add(id2, patient2);
        } catch (AddingException e) {
            Assert.fail();
        }
        List<Patient> expected = new ArrayList<>();
        expected.add(patient2);
        expected.add(patient);
        List<Patient> actual = patientDao.findAllByMedicalCardRange(0, 1);
        Assert.assertEquals(actual, expected);
    }

    @AfterMethod(onlyForGroups = "findAll")
    public void deletePatient2() {
        try {
            patientDao.delete(patient2);
        } catch (DeletingException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void deletePatient() {
        try {
            patientDao.delete(patient);
        } catch (DeletingException e) {
            e.printStackTrace();
        }
    }
}