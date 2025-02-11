// 6. Circular Linked List: Round Robin Scheduling Algorithm

class Process {
    int processId;
    int burstTime;
    int priority;
    Process next;
    int waitingTime;  // Added for calculations
    int turnaroundTime; // Added for calculations

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
    }

    @Override
    public String toString() {
        return "ID: " + processId + ", Burst: " + burstTime + ", Priority: " + priority +
               ", Waiting: " + waitingTime + ", Turnaround: " + turnaroundTime;
    }
}

class Scheduler {
    Process head;
    int timeQuantum;

    public Scheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(Process newProcess) {
        if (head == null) {
            newProcess.next = newProcess;
            head = newProcess;
            return;
        }
        Process tail = head;
        while (tail.next != head) {
            tail = tail.next;
        }
        tail.next = newProcess;
        newProcess.next = head;
    }

    public void removeProcess(int processId) {
        if (head == null) return;

        if (head.processId == processId) {
            if (head.next == head) {
                head = null;
            } else {
                Process tail = head;
                while (tail.next != head) {
                    tail = tail.next;
                }
                tail.next = head.next;
                head = head.next;
            }
            return;
        }

        Process current = head;
        while (current.next != head && current.next.processId != processId) {
            current = current.next;
        }

        if (current.next != head) {
            current.next = current.next.next;
        }
    }

    public void simulateScheduling() {
        if (head == null) return;

        int currentTime = 0;
        Process currentProcess = head;

        while (true) {
            displayProcesses(); // Display after each round

            if (currentProcess.burstTime <= 0 && currentProcess.next == head) break; //All processes are complete

            int executionTime = Math.min(timeQuantum, currentProcess.burstTime);
            currentProcess.burstTime -= executionTime;
            currentTime += executionTime;

            Process nextProcess = currentProcess.next;

            // Update waiting times for other processes
            Process temp = nextProcess;
            while (temp != currentProcess) {
                if (temp.burstTime > 0) {
                    temp.waitingTime += executionTime;
                }
                temp = temp.next;
            }

            currentProcess.turnaroundTime = currentTime; //Calculate turnaround time
            currentProcess = nextProcess;

            if(currentProcess.burstTime <= 0) {
                removeProcess(currentProcess.processId);
                if(head == null) break; //All processes are complete
                currentProcess = nextProcess; //Move to the next process after removal
            }
        }

        calculateAverageTimes();
    }

    public void displayProcesses() {
        if (head == null) return;

        Process current = head;
        do {
            System.out.println(current);
            current = current.next;
        } while (current != head);
        System.out.println(); // Add a newline for clarity
    }

    public void calculateAverageTimes() {
        if (head == null) return;

        double totalWaitingTime = 0;
        double totalTurnaroundTime = 0;
        int processCount = 0;

        Process current = head;
        do {
            totalWaitingTime += current.waitingTime;
            totalTurnaroundTime += current.turnaroundTime;
            processCount++;
            current = current.next;
        } while (current != head);

        double avgWaitingTime = totalWaitingTime / processCount;
        double avgTurnaroundTime = totalTurnaroundTime / processCount;

        System.out.println("\nAverage Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }
}

public class RoundRobinScheduler {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler(2); // Time quantum = 2

        scheduler.addProcess(new Process(1, 5, 1));
        scheduler.addProcess(new Process(2, 3, 2));
        scheduler.addProcess(new Process(3, 7, 3));

        System.out.println("Initial Processes:");
        scheduler.displayProcesses();

        System.out.println("\nScheduling Simulation:");
        scheduler.simulateScheduling();
    }
}