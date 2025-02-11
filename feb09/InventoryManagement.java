// 4. Singly Linked List: Inventory Management System

class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item: " + itemName + ", ID: " + itemId + ", Quantity: " + quantity + ", Price: " + price;
    }
}

class Inventory {
    Item head;

    public void addItemAtBeginning(Item newItem) {
        newItem.next = head;
        head = newItem;
    }

    public void addItemAtEnd(Item newItem) {
        if (head == null) {
            head = newItem;
            return;
        }
        Item current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newItem;
    }

    public void addItemAtPosition(Item newItem, int position) {
        if (position <= 0) {
            addItemAtBeginning(newItem);
            return;
        }
        if (head == null) return; //List is empty

        Item current = head;
        int count = 0;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current == null) { // Position is out of range
            addItemAtEnd(newItem); // Or handle as error
            return;
        }

        newItem.next = current.next;
        current.next = newItem;
    }


    public void removeItemById(int itemId) {
        if (head == null) return;

        if (head.itemId == itemId) {
            head = head.next;
            return;
        }

        Item current = head;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void updateQuantity(int itemId, int newQuantity) {
        Item item = searchItemById(itemId);
        if (item != null) {
            item.quantity = newQuantity;
        }
    }

    public Item searchItemById(int itemId) {
        Item current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public Item searchItemByName(String itemName) {
        Item current = head;
        while (current != null) {
            if (current.itemName.equals(itemName)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public double calculateTotalValue() {
        double totalValue = 0;
        Item current = head;
        while (current != null) {
            totalValue += current.quantity * current.price;
            current = current.next;
        }
        return totalValue;
    }

    // Merge Sort for Linked List (Ascending by Item Name)
    public void sortByName() {
        head = mergeSortByName(head);
    }

    private Item mergeSortByName(Item h) {
        if (h == null || h.next == null) {
            return h;
        }

        Item middle = getMiddle(h);
        Item secondHalf = middle.next;
        middle.next = null;

        Item left = mergeSortByName(h);
        Item right = mergeSortByName(secondHalf);

        return mergeByName(left, right);
    }

    private Item mergeByName(Item left, Item right) {
        Item dummyHead = new Item("", 0, 0, 0); // Dummy node
        Item current = dummyHead;

        while (left != null && right != null) {
            if (left.itemName.compareTo(right.itemName) <= 0) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        current.next = (left != null) ? left : right;
        return dummyHead.next;
    }

    private Item getMiddle(Item h) {
        if (h == null) {
            return null;
        }

        Item slow = h;
        Item fast = h;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public void sortByPrice() {
        head = mergeSortByPrice(head);
    }

    private Item mergeSortByPrice(Item h) {
        if (h == null || h.next == null) {
            return h;
        }

        Item middle = getMiddle(h);
        Item secondHalf = middle.next;
        middle.next = null;

        Item left = mergeSortByPrice(h);
        Item right = mergeSortByPrice(secondHalf);

        return mergeByPrice(left, right);
    }

    private Item mergeByPrice(Item left, Item right) {
        Item dummyHead = new Item("", 0, 0, 0); // Dummy node
        Item current = dummyHead;

        while (left != null && right != null) {
            if (left.price <= right.price) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        current.next = (left != null) ? left : right;
        return dummyHead.next;
    }


    public void displayInventory() {
        Item current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}

public class InventoryManagement {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItemAtEnd(new Item("Laptop", 1, 10, 1200.0));
        inventory.addItemAtEnd(new Item("Mouse", 2, 20, 25.0));
        inventory.addItemAtBeginning(new Item("Keyboard", 3, 15, 75.0));
        inventory.addItemAtPosition(new Item("Monitor", 4, 5, 300.0), 2);

        System.out.println("Inventory:");
        inventory.displayInventory();

        inventory.removeItemById(2);
        System.out.println("\nAfter removing item 2:");
        inventory.displayInventory();

        inventory.updateQuantity(1, 12);
        System.out.println("\nAfter updating quantity of item 1:");
        inventory.displayInventory();

        System.out.println("\nTotal Value: " + inventory.calculateTotalValue());

        inventory.sortByName();
        System.out.println("\nSorted by name:");
        inventory.displayInventory();

        inventory.sortByPrice();
        System.out.println("\nSorted by price:");
        inventory.displayInventory();

    }
}