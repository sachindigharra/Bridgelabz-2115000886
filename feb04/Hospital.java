package feb04;
import java.util.*;

class Hospital {
    String name;
    ArrayList<Doctor> doctors;
    ArrayList<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }
}

class Doctor {
    String name;
    ArrayList<Patient> patients; // Doctors can have multiple patients

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    public void consult(Patient patient) {
        System.out.println("Dr. " + name + " is consulting with " + patient.name);
    }
}

class Patient {
    String name;
    ArrayList<Doctor> doctors; // Patients can consult multiple doctors

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
    }
}
