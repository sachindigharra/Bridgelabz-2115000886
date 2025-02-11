
import java.util.ArrayList;
import java.util.List;

// Abstract class Patient
abstract class Patient {
    private int patientId;
    private String name;
    private int age;
    private String diagnosis;

    public Patient(int patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Age: " + age + ", Diagnosis: " + diagnosis);
    }

    public abstract double calculateBill();
}

// Interface MedicalRecord
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {
    private double dailyRate;
    private int numberOfDays;
    private List<String> medicalRecords = new ArrayList<>();

    public InPatient(int patientId, String name, int age, String diagnosis, double dailyRate, int numberOfDays) {
        super(patientId, name, age, diagnosis);
        this.dailyRate = dailyRate;
        this.numberOfDays = numberOfDays;
    }

    @Override
    public double calculateBill() {
        return dailyRate * numberOfDays;
    }

    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for InPatient " + getName() + ":");
        for (String record : medicalRecords) {
            System.out.println("- " + record);
        }
    }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> medicalRecords = new ArrayList<>();

    public OutPatient(int patientId, String name, int age, String diagnosis, double consultationFee) {
        super(patientId, name, age, diagnosis);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for OutPatient " + getName() + ":");
        for (String record : medicalRecords) {
            System.out.println("- " + record);
        }
    }
}

// Main class to demonstrate the functionality
public class HospitalManagementSystem {
    public static void main(String[] args) {
        Patient inPatient = new InPatient(101, "John Doe", 45, "Pneumonia", 2000.0, 5);
        Patient outPatient = new OutPatient(102, "Jane Smith", 30, "Flu", 500.0);

        System.out.println("InPatient Details:");
        inPatient.getPatientDetails();
        System.out.println("Total Bill: " + inPatient.calculateBill());

        System.out.println("\nOutPatient Details:");
        outPatient.getPatientDetails();
        System.out.println("Total Bill: " + outPatient.calculateBill());

        System.out.println("\nAdding Medical Records...");
        MedicalRecord recordInPatient = (MedicalRecord) inPatient;
        recordInPatient.addRecord("Admitted for Pneumonia treatment.");
        recordInPatient.addRecord("Discharged after 5 days.");

        MedicalRecord recordOutPatient = (MedicalRecord) outPatient;
        recordOutPatient.addRecord("Consultation for flu symptoms.");
        
        System.out.println("\nViewing Medical Records:");
        recordInPatient.viewRecords();
        recordOutPatient.viewRecords();
    }
}

