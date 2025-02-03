package feb3;

public class Patient {
    static String hospitalName = "City Hospital";
    private static int totalPatients = 0;

    final int patientID;
    String name;
    int age;
    String ailment;

    private static int patientCounter = 1; // To generate unique IDs

    public Patient(String name, int age, String ailment) {
        this.patientID = patientCounter++; // Assign unique ID
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    public static int getTotalPatients() {
        return totalPatients;
    }

    public void displayPatientDetails() {
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
        System.out.println("Hospital: " + hospitalName);
    }

    public static void main(String[] args) {
        Patient patient1 = new Patient("David", 35, "Fever");
        Patient patient2 = new Patient("Sarah", 28, "Cold");

        if (patient1 instanceof Patient) {
            patient1.displayPatientDetails();
        }

        if (patient2 instanceof Patient) {
            patient2.displayPatientDetails();
        }

        System.out.println("Total Patients: " + Patient.getTotalPatients());
    }
}