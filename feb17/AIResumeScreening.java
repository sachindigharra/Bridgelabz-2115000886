package Feb17;

import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String candidateName;
    
    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }
    
    public String getCandidateName() {
        return candidateName;
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + " - " + candidateName;
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName) {
        super(candidateName);
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName) {
        super(candidateName);
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName) {
        super(candidateName);
    }
}

class Resume<T extends JobRole> {
    private List<T> candidates = new ArrayList<>();
    
    public void addCandidate(T candidate) {
        candidates.add(candidate);
    }
    
    public List<T> getCandidates() {
        return candidates;
    }
}

class ResumeScreeningSystem {
    public static void processResumes(List<? extends JobRole> candidates) {
        System.out.println("Processing Resumes:");
        for (JobRole candidate : candidates) {
            System.out.println(candidate);
        }
    }
}

public class AIResumeScreening {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> softwareEngineerResumes = new Resume<>();
        softwareEngineerResumes.addCandidate(new SoftwareEngineer("Alice"));
        softwareEngineerResumes.addCandidate(new SoftwareEngineer("Bob"));

        Resume<DataScientist> dataScientistResumes = new Resume<>();
        dataScientistResumes.addCandidate(new DataScientist("Charlie"));
        dataScientistResumes.addCandidate(new DataScientist("David"));

        Resume<ProductManager> productManagerResumes = new Resume<>();
        productManagerResumes.addCandidate(new ProductManager("Eve"));
        productManagerResumes.addCandidate(new ProductManager("Frank"));

        System.out.println("Software Engineer Resumes:");
        ResumeScreeningSystem.processResumes(softwareEngineerResumes.getCandidates());

        System.out.println("\nData Scientist Resumes:");
        ResumeScreeningSystem.processResumes(dataScientistResumes.getCandidates());

        System.out.println("\nProduct Manager Resumes:");
        ResumeScreeningSystem.processResumes(productManagerResumes.getCandidates());
    }
}
