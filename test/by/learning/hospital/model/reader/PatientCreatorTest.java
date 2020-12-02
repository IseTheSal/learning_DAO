package by.learning.hospital.model.reader;

import by.learning.hospital.model.entity.Patient;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientCreatorTest {

    PatientReader patientCreator;
    List<Patient> patientList;

    final String ONE_PATIENT_PATH = "data\\patient.txt";
    final String PATIENTS_PATH = "data\\fillPatients.txt";

    @BeforeClass
    public void init() {
        patientCreator = new PatientReader();
    }

    @BeforeMethod(onlyForGroups = "fillArray")
    public void fillArray() {
        patientList = new ArrayList<>();
        patientList.add(new Patient("Andrew", "Markovskiy", "Antonovich", "Nezalegnosti 4", "+375256343454"));
        patientList.add(new Patient("Anton", "Minkiy", "Sergeevich", "Nezalegnosti 12a", "+3754445645659"));
        patientList.add(new Patient("Ivan", "Ivanov", "Ivanovich", "Nezalegnosti 3 ", "+375256343454"));
        patientList.add(new Patient("Michail", "Michailov", "Michailovich", "Novay 9", "+37525345354"));
        patientList.add(new Patient("Roman", "Romanov", "Romanovich", "Nezalegnosti 4", "+375256378951"));
        patientList.add(new Patient("Artem", "Artemov", "Artemovich", "Nezalegnosti 7", "+375256367856"));
        patientList.add(new Patient("Genadiy", "Genadiev", "Genadevich", "Nezalegnosti 14", "+3752563345554"));
        patientList.add(new Patient("Grigoriy", "Grigoriev", "Grigorevich", "Nezalegnosti 24", "+3752564566453"));
        patientList.add(new Patient("Alexandr", "Alexandrov", "Alexandrovich", "Nezalegnosti 34", "+3752563423458"));
        patientList.add(new Patient("Mark", "Markov", "Markovich", "Nezalegnosti 54", "+3752564566459"));
    }

    @Test
    public void testCreateOnePatient() {
        File file = new File(ONE_PATIENT_PATH);
        Optional<Patient> actual = patientCreator.createPatient(file);
        Patient expected = new Patient("Vaseliy", "Vaseliev", "Vaselivich", "October 4", "+375447864534");
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = "fillArray")
    public void testCreatePatients() {
        File file = new File(PATIENTS_PATH);
        List<Patient> actual = patientCreator.createPatientList(file);
        List<Patient> expected = patientList;
        Assert.assertEquals(actual, expected);
    }

    @AfterClass
    public void setAllNull() {
        patientList = null;
        patientCreator = null;
    }

}