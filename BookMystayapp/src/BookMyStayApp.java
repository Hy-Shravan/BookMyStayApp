import java.util.*;

// Reservation (Represents guest booking request)
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

// Booking Request Queue (FIFO)
class BookingRequestQueue {
    private Queue<Reservation> queue = new LinkedList<>();

    // Add request (enqueue)
    public void addRequest(Reservation reservation) {
        queue.offer(reservation);
        System.out.println("Request added: " + reservation.getGuestName() +
                " -> " + reservation.getRoomType());
    }

    // View queue (read-only, no removal)
    public void displayQueue() {
        System.out.println("\nBooking Request Queue (FIFO Order):\n");

        if (queue.isEmpty()) {
            System.out.println("No booking requests.");
            return;
        }

        for (Reservation r : queue) {
            System.out.println("Guest: " + r.getGuestName() +
                    ", Room Type: " + r.getRoomType());
        }
    }
}

// Main Class
public class UseCase5BookingQueue {
    public static void main(String[] args) {

        // Create queue system
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Guests submit requests (arrival order matters)
        bookingQueue.addRequest(new Reservation("Rishi", "Single"));
        bookingQueue.addRequest(new Reservation("Amit", "Double"));
        bookingQueue.addRequest(new Reservation("Neha", "Suite"));
        bookingQueue.addRequest(new Reservation("Rahul", "Single"));

        // Display queue (FIFO order preserved)
        bookingQueue.displayQueue();
    }
}