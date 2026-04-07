
import java.util.HashMap;
import java.util.Map;

class RoomInventory {

    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        // Predefined room types with initial counts
        inventory.put("Single Room", 10);
        inventory.put("Double Room", 5);
        inventory.put("Suite Room", 2);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public boolean bookRoom(String roomType) {
        int available = inventory.getOrDefault(roomType, 0);
        if (available > 0) {
            inventory.put(roomType, available - 1);
            return true;
        }
        return false;
    }
    public void cancelBooking(String roomType) {
        int available = inventory.getOrDefault(roomType, 0);
        inventory.put(roomType, available + 1);
    }

    public void displayInventory() {
        System.out.println("Current Room Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " -> Available: " + entry.getValue());
        }
        System.out.println();
    }
}

public class HotelBookingApp {

    public static void main(String[] args) {

        // Initialize centralized inventory
        RoomInventory roomInventory = new RoomInventory();

        // Display initial inventory
        roomInventory.displayInventory();

        // Book some rooms
        System.out.println("Booking a Single Room...");
        roomInventory.bookRoom("Single Room");
        System.out.println("Booking a Suite Room...");
        roomInventory.bookRoom("Suite Room");

        // Display updated inventory
        roomInventory.displayInventory();

        // Cancel a booking
        System.out.println("Cancelling a Double Room booking...");
        roomInventory.cancelBooking("Double Room");

        // Display final inventory
        roomInventory.displayInventory();
    }
}