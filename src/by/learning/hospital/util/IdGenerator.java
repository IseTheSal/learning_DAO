package by.learning.hospital.util;

public class IdGenerator {

    private static long currentId = 0;

    private static long currentMedicalCardId = 0;

    public static long getCurrentId() {
        return currentId++;
    }

    public static long getCurrentMedicalCardId() {
        return currentMedicalCardId++;
    }
}
