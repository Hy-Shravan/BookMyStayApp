
abstract class Room {
    private int numberOfBeds;
    private double size;       // in square meters
    private double price;      // per night

    // Constructor
    public Room(int numberOfBeds, double size, double price) {
        this.numberOfBeds = numberOfBeds;
        this.size = size;
        this.price = price;
    }

    // Getters
    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    // Abstract method to get room type name
    public abstract String getRoomType();

    // Display room details
    public void displayRoomDetails() {
        System.out.println(getRoomType() + " Details:");
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + size + " sqm");
        System.out.println("Price: $" + price + " per night");
    }
}

class SingleRoom extends Room {
    public SingleRoom() {
        super(1, 15.0, 50.0);
    }

    @Override
    public String getRoomType() {
        return "Single Room";
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super(2, 25.0, 90.0);
    }

    @Override
    public String getRoomType() {
        return "Double Room";
    }
}
class SuiteRoom extends Room {
    public SuiteRoom() {
        super(3, 45.0, 180.0);
    }

    @Override
    public String getRoomType() {
        return "Suite Room";
    }
}

public class HotelBookingApp {
    public static void main(String[] args) {

        // Create room objects
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Store availability using individual variables
        int singleRoomAvailability = 10;
        int doubleRoomAvailability = 5;
        int suiteRoomAvailability = 2;

        // Display room details and availability
        singleRoom.displayRoomDetails();
        System.out.println("Available: " + singleRoomAvailability);
        System.out.println();

        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleRoomAvailability);
        System.out.println();

        suiteRoom.displayRoomDetails();
        System.out.println("Available: " + suiteRoomAvailability);
        System.out.println();
    }
}