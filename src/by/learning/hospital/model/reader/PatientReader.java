package by.learning.hospital.model.reader;

import by.learning.hospital.model.entity.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PatientReader {
    private static final Logger logger = LogManager.getLogger(PatientReader.class);

    private static final String DELIMITER = "&";

    public Optional<Patient> createPatient(File file) {
        Optional<Patient> result = Optional.empty();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            String fullPatient = scanner.nextLine();
            String[] fullPatientFields = fullPatient.split(DELIMITER);
            String firstName = fullPatientFields[0];
            String secondName = fullPatientFields[1];
            String patronymic = fullPatientFields[2];
            String address = fullPatientFields[3];
            String phoneNumber = fullPatientFields[4];
            Patient patient = new Patient(firstName, secondName, patronymic, address, phoneNumber);
            result = Optional.of(patient);
        } catch (FileNotFoundException e) {
            logger.error("Error in create patient: ", e);
        } finally {
            scanner.close();
        }
        return result;
    }

    public List<Patient> createPatientList(File file) {
        List<Patient> result = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String fullPatient = scanner.nextLine();
                String[] fullPatientFields = fullPatient.split(DELIMITER);
                String firstName = fullPatientFields[0];
                String secondName = fullPatientFields[1];
                String patronymic = fullPatientFields[2];
                String address = fullPatientFields[3];
                String phoneNumber = fullPatientFields[4];
                Patient patient = new Patient(firstName, secondName, patronymic, address, phoneNumber);
                result.add(patient);
            }
        } catch (FileNotFoundException e) {
            logger.error("Error in create patient: ", e);
        } finally {
            scanner.close();
        }
        return result;
    }
}
