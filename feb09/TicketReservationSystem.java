// 9. Circular Linked List: Online Ticket Reservation System

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId + ", Customer: " + customerName +
               ", Movie: " + movieName + ", Seat: " + seatNumber + ", Time: " + bookingTime;
    }
}

class ReservationSystem {
    Ticket head;

    public void addReservation(Ticket newTicket) {
        if (head == null) {
            newTicket.next = newTicket; // Make it circular
            head = newTicket;
            return;
        }

        Ticket tail = head;
        while (tail.next != head) {
            tail = tail.next;
        }

        tail.next = newTicket;
        newTicket.next = head; // Maintain circularity
    }

    public void removeTicket(int ticketId) {
        if (head == null) return;

        if (head.ticketId == ticketId) {
            if (head.next == head) { // Only one ticket
                head = null;
            } else {
                Ticket tail = head;
                while (tail.next != head) {
                    tail = tail.next;
                }
                tail.next = head.next;
                head = head.next;
            }
            return;
        }

        Ticket current = head;
        while (current.next != head && current.next.ticketId != ticketId) {
            current = current.next;
        }

        if (current.next != head) {
            current.next = current.next.next;
        }
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked yet.");
            return;
        }

        Ticket current = head;
        do {
            System.out.println(current);
            current = current.next;
        } while (current != head);
    }

    public Ticket searchTicketByCustomer(String customerName) {
        if (head == null) return null;

        Ticket current = head;
        do {
            if (current.customerName.equals(customerName)) {
                return current;
            }
            current = current.next;
        } while (current != head);

        return null;
    }

    public Ticket searchTicketByMovie(String movieName) {
        if (head == null) return null;

        Ticket current = head;
        do {
            if (current.movieName.equals(movieName)) {
                return current;
            }
            current = current.next;
        } while (current != head);

        return null;
    }

    public int countBookedTickets() {
        if (head == null) return 0;

        int count = 0;
        Ticket current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);

        return count;
    }
}

public class TicketReservationSystem {
    public static void main(String[] args) {
        ReservationSystem system = new ReservationSystem();

        system.addReservation(new Ticket(1, "Alice", "Movie X", "A1", "2024-03-10 10:00"));
        system.addReservation(new Ticket(2, "Bob", "Movie Y", "B2", "2024-03-10 14:00"));
        system.addReservation(new Ticket(3, "Charlie", "Movie X", "C3", "2024-03-11 12:00"));

        System.out.println("Booked Tickets:");
        system.displayTickets();

        system.removeTicket(2);
        System.out.println("\nAfter removing ticket 2:");
        system.displayTickets();

        Ticket foundByCustomer = system.searchTicketByCustomer("Alice");
        if (foundByCustomer != null) {
            System.out.println("\nFound by customer: " + foundByCustomer);
        }

        Ticket foundByMovie = system.searchTicketByMovie("Movie X");
        if (foundByMovie != null) {
            System.out.println("\nFound by movie: " + foundByMovie);
        }

        System.out.println("\nTotal booked tickets: " + system.countBookedTickets());
    }
}