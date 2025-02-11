

class TextState {
    String text;
    TextState next;
    TextState prev;

    public TextState(String text) {
        this.text = text;
    }
}

public class TextEditor {
    TextState currentState;
    TextState head;
    int historySize; // Limit history size

    public TextEditor(int historySize) {
        this.historySize = historySize;
        this.currentState = new TextState(""); // Initial state
        this.head = currentState;
    }

    public void addState(String text) {
        TextState newState = new TextState(text);
        currentState.next = newState;
        newState.prev = currentState;
        currentState = newState;

        // Limit History
        int size = 0;
        TextState temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        while (size > historySize) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void undo() {
        if (currentState.prev != null) {
            currentState = currentState.prev;
        }
    }

    public void redo() {
        if (currentState.next != null) {
            currentState = currentState.next;
        }
    }

    public void displayCurrentText() {
        System.out.println("Current Text: " + currentState.text);
    }


    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10); // History size = 10

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");

        editor.displayCurrentText(); // Output: Hello World!

        editor.undo();
        editor.displayCurrentText(); // Output: Hello World

        editor.undo();
        editor.displayCurrentText(); // Output: Hello

        editor.redo();
        editor.displayCurrentText(); // Output: Hello World

        editor.addState("Hello World!! This is a long string to test history limit");
        editor.addState("Hello World!!! This is a long string to test history limit");
        editor.addState("Hello World!!!! This is a long string to test history limit");
        editor.addState("Hello World!!!!! This is a long string to test history limit");
        editor.addState("Hello World!!!!!! This is a long string to test history limit");
        editor.addState("Hello World!!!!!!! This is a long string to test history limit");
        editor.addState("Hello World!!!!!!!! This is a long string to test history limit");
        editor.addState("Hello World!!!!!!!!! This is a long string to test history limit");
        editor.addState("Hello World!!!!!!!!!! This is a long string to test history limit");
        editor.addState("Hello World!!!!!!!!!!! This is a long string to test history limit");
        editor.addState("Hello World!!!!!!!!!!!! This is a long string to test history limit");

        editor.displayCurrentText();

        editor.undo();
        editor.displayCurrentText();

        editor.undo();
        editor.displayCurrentText();

        editor.undo();
        editor.displayCurrentText();

        editor.undo();
        editor.displayCurrentText();
    }
}