import java.time.LocalDate; //  for handling dates
import java.util.ArrayList; //  for ArrayList data structure
import java.util.Comparator; //  for Comparator interface
import java.util.concurrent.TimeUnit; //  for time-related operations

// enum representing severity levels
enum Severity {
    ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN
}

// Class representing a patient
class Patient {
    // Member variables for Patient class
    private final String patientName; // Name of the patient
    private final LocalDate patientDateOfBirth; // Date of birth of the patient
    private Severity patientSeverity; // severity level of the patient's condition
    private LocalDate patientArrivalTime; // Time when the patient arrived at the emergency room

    // Constructor for Patient class
    public Patient(String name, LocalDate dob) {
        this.patientName = name;
        this.patientDateOfBirth = dob;
    }

    // Getter methods for accessing patient attributes
    public String getPatientName() { return patientName; }
    public LocalDate getPatientDateOfBirth() { return patientDateOfBirth; }
    public Severity getPatientSeverity() { return patientSeverity; }
    public LocalDate getPatientArrivalTime() { return patientArrivalTime; } // Added getter method for patient arrival time

    // setter methods for modifying patient attributes
    public void setPatientSeverity(Severity severity) { this.patientSeverity = severity; }
    public void setPatientArrivalTime(LocalDate arrivalTime) { this.patientArrivalTime = arrivalTime; }

    // ToString method to represent patient information as a string
    @Override
    public String toString() {
        return "Name: " + patientName + ", DOB: " + patientDateOfBirth + ", Severity: " + patientSeverity + ", Arrival Time: " + patientArrivalTime;
    }
}

// Comparator for comparing patients based on severity, date of birth, and arrival time
class PatientComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient patient1, Patient patient2) {
        if (patient1.getPatientSeverity() != patient2.getPatientSeverity())
            return patient2.getPatientSeverity().compareTo(patient1.getPatientSeverity());
        else if (!patient1.getPatientDateOfBirth().equals(patient2.getPatientDateOfBirth()))
            return patient1.getPatientDateOfBirth().compareTo(patient2.getPatientDateOfBirth());
        else
            return patient1.getPatientArrivalTime().compareTo(patient2.getPatientArrivalTime());
    }
}

// Min-heap data structure for storing elements
class Heap<T> {
    private final ArrayList<T> heapArray; // arrayList to store heap elements
    private final Comparator<T> heapComparator; // Comparator for comparing elements

    // Constructor for Heap class
    public Heap(Comparator<T> comparator) {
        this.heapArray = new ArrayList<>();
        this.heapComparator = comparator;
    }

    // Method to add an element to the heap
    public void add(T element) {
        heapArray.add(element);
        int current = heapArray.size() - 1;
        while (current > 0 && heapComparator.compare(heapArray.get(current), heapArray.get(parent(current))) < 0) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Method to remove the root element from the heap
    public T remove() {
        if (heapArray.isEmpty())
            return null;

        T root = heapArray.get(0);
        heapArray.set(0, heapArray.get(heapArray.size() - 1));
        heapArray.remove(heapArray.size() - 1);

        minHeapify(0);

        return root;
    }

    private void minHeapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;

        if (left < heapArray.size() && heapComparator.compare(heapArray.get(left), heapArray.get(smallest)) < 0)
            smallest = left;
        if (right < heapArray.size() && heapComparator.compare(heapArray.get(right), heapArray.get(smallest)) < 0)
            smallest = right;

        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    private void swap(int i, int j) {
        T temp = heapArray.get(i);
        heapArray.set(i, heapArray.get(j));
        heapArray.set(j, temp);
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }
}

// class representing an emergency room
class EmergencyRoom {
    private final Heap<Patient> patientPriorityQueue; // Priority queue for managing patients

    // Constructor for EmergencyRoom class
    public EmergencyRoom(Comparator<Patient> comparator) {
        this.patientPriorityQueue = new Heap<>(comparator);
    }

    // Method for checking in a patient with specified severity
    public void checkIn(Patient patient, Severity severity) {
        patient.setPatientSeverity(severity);
        patient.setPatientArrivalTime(LocalDate.now());
        patientPriorityQueue.add(patient);
    }

    // method for admitting the next patient in the priority queue
    public Patient admit() {
        return patientPriorityQueue.remove();
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Main method where the program starts execution
        EmergencyRoom emergencyRoom = new EmergencyRoom(new PatientComparator()); // creating an EmergencyRoom object

        // checking in patients
        emergencyRoom.checkIn(new Patient("Mirabella Jones", LocalDate.of(1973, 7, 11)), Severity.SEVEN);
        TimeUnit.MILLISECONDS.sleep(10);
        emergencyRoom.checkIn(new Patient("Ruth Mendez", LocalDate.of(1965, 1, 22)), Severity.SEVEN);
        TimeUnit.MILLISECONDS.sleep(10);
        emergencyRoom.checkIn(new Patient("Melvin Ingram", LocalDate.of(1965, 1, 22)), Severity.SEVEN);
        TimeUnit.MILLISECONDS.sleep(10);
        emergencyRoom.checkIn(new Patient("Tara Silva", LocalDate.of(1975, 5, 8)), Severity.EIGHT);
        TimeUnit.MILLISECONDS.sleep(10);
        emergencyRoom.checkIn(new Patient("Jeff Barnes", LocalDate.of(1968, 12, 19)), Severity.EIGHT);

        // Admitting patients
        Patient patient;
        while ((patient = emergencyRoom.admit()) != null) {
            System.out.println(patient + " admitted");
        }
    }
}
