package by.learning.hospital.util;

public class IdGenerator {

    private static int currentId = 0;

    private static int currentMedicalCardId = 0;

    public static int getCurrentId() {
        return currentId++;
    }

    public static int getCurrentMedicalCardId() {
        return currentMedicalCardId++;
    }
}
