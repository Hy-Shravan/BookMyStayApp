import java.util.*;

// Room Class
class Room {
    private String type;
    private double price;
    private String amenities;

    public Room(String type, double price, String amenities) {
        this.type = type;
        this.price = price;
        this.amenities = amenities;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getAmenities() {
        return amenities;
    }
}

// Inventory Class
class RoomInventory {
    private Map<String, Integer> availability = new HashMap<>();

    public void addRoom(String type, int count) {
        availability.put(type, count);
    }

    public Map<String, Integer> getRoomAvailability() {
        return availability; // Read-only usage
    }
}

// Search Service
class SearchService {

    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        // Single Room
        if (availability.getOrDefault("Single", 0) > 0) {
            System.out.println("Room Type: " + singleRoom.getType());
            System.out.println("Price: ₹" + singleRoom.getPrice());
            System.out.println("Amenities: " + singleRoom.getAmenities());
            System.out.println("Available: " + availability.get("Single"));
            System.out.println("---------------------------");
        }

        // Double Room
        if (availability.getOrDefault("Double", 0) > 0) {
            System.out.println("Room Type: " + doubleRoom.getType());
            System.out.println("Price: ₹" + doubleRoom.getPrice());
            System.out.println("Amenities: " + doubleRoom.getAmenities());
            System.out.println("Available: " + availability.get("Double"));
            System.out.println("---------------------------");
        }

        // Suite Room
        if (availability.getOrDefault("Suite", 0) > 0) {
            System.out.println("Room Type: " + suiteRoom.getType());
            System.out.println("Price: ₹" + suiteRoom.getPrice());
            System.out.println("Amenities: " + suiteRoom.getAmenities());
            System.out.println("Available: " + availability.get("Suite"));
            System.out.println("---------------------------");
        }
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        // Create Rooms
        Room single = new Room("Single", 1000, "Bed, Fan");
        Room dbl = new Room("Double", 2000, "AC, TV");
        Room suite = new Room("Suite", 4000, "AC, TV, WiFi");

        // Setup Inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoom("Single", 3);
        inventory.addRoom("Double", 0); // filtered out
        inventory.addRoom("Suite", 2);

        // Search
        SearchService service = new SearchService();
        service.searchAvailableRooms(inventory, single, dbl, suite);
    }
}