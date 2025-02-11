// 3. Circular Linked List: Task Scheduler

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId + ", Name: " + taskName + ", Priority: " + priority + ", Due Date: " + dueDate;
    }
}

class TaskList {
    Task head;

    public void addTaskAtBeginning(Task newTask) {
        if (head == null) {
            newTask.next = newTask; // Point to itself for a single-node list
            head = newTask;
            return;
        }
        Task tail = head;
        while (tail.next != head) {
            tail = tail.next;
        }
        newTask.next = head;
        tail.next = newTask;
        head = newTask;
    }

    public void addTaskAtEnd(Task newTask) {
        if (head == null) {
            newTask.next = newTask;
            head = newTask;
            return;
        }

        Task tail = head;
        while (tail.next != head) {
            tail = tail.next;
        }
        tail.next = newTask;
        newTask.next = head;
    }

    public void addTaskAtPosition(Task newTask, int position) {
        if (position <= 0) {
            addTaskAtBeginning(newTask);
            return;
        }
        if (head == null) return; //List is empty

        Task current = head;
        int count = 0;
        while (current.next != head && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current.next == head && count < position -1) { // Position is out of range
            addTaskAtEnd(newTask); // Or handle as error
            return;
        }

        newTask.next = current.next;
        current.next = newTask;
    }


    public void removeTaskById(int taskId) {
        if (head == null) return;

        if (head.taskId == taskId) {
            if (head.next == head) { // Only one node
                head = null;
            } else {
                Task tail = head;
                while (tail.next != head) {
                    tail = tail.next;
                }
                tail.next = head.next;
                head = head.next;
            }
            return;
        }

        Task current = head;
        while (current.next != head && current.next.taskId != taskId) {
            current = current.next;
        }

        if (current.next != head) {
            current.next = current.next.next;
        }
    }

    public Task viewCurrentTask() {
        return head;
    }

    public void moveToNextTask() {
        if (head != null) {
            head = head.next;
        }
    }

    public void displayAllTasks() {
        if (head == null) return;

        Task current = head;
        do {
            System.out.println(current);
            current = current.next;
        } while (current != head);
    }

    public Task searchTaskByPriority(int priority) {
        if (head == null) return null;

        Task current = head;
        do {
            if (current.priority == priority) {
                return current;
            }
            current = current.next;
        } while (current != head);

        return null; // Not found
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();

        taskList.addTaskAtEnd(new Task(1, "Task A", 2, "2024-03-15"));
        taskList.addTaskAtEnd(new Task(2, "Task B", 1, "2024-03-20"));
        taskList.addTaskAtBeginning(new Task(0, "Task C", 3, "2024-03-10"));
        taskList.addTaskAtPosition(new Task(4, "Task D", 2, "2024-03-25"), 2);


        System.out.println("All Tasks:");
        taskList.displayAllTasks();

        taskList.removeTaskById(2);
        System.out.println("\nAfter removing Task 2:");
        taskList.displayAllTasks();

        Task currentTask = taskList.viewCurrentTask();
        System.out.println("\nCurrent Task: " + currentTask);

        taskList.moveToNextTask();
        currentTask = taskList.viewCurrentTask();
        System.out.println("\nNext Task: " + currentTask);

        Task foundTask = taskList.searchTaskByPriority(2);
        if (foundTask != null) {
            System.out.println("\nFound task by priority 2: " + foundTask);
        }
    }
}