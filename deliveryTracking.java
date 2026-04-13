import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

// Parcel Class
class Parcel {
    private String parcelId;
    private String status;
    private ArrayList<String> timeline;

    public Parcel(String parcelId) {
        this.parcelId = parcelId;
        this.status = "Dispatched";
        this.timeline = new ArrayList<>();
        addTimeline("Parcel Dispatched");
    }

    public String getParcelId() {
        return parcelId;
    }

    public String getStatus() {
        return status;
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
        addTimeline("Status updated to: " + newStatus);
    }

    private void addTimeline(String event) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String time = LocalDateTime.now().format(dtf);
        timeline.add(event + " at " + time);
    }

    public void showDetails() {
        System.out.println("\nParcel ID: " + parcelId);
        System.out.println("Current Status: " + status);
        System.out.println("Timeline:");
        for (String event : timeline) {
            System.out.println(" - " + event);
        }
    }
}

// Main System Class
public class deliveryTracking {
    static ArrayList<Parcel> parcelList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== COURIER TRACKING SYSTEM =====");
            System.out.println("1. Add Parcel");
            System.out.println("2. Update Parcel Status");
            System.out.println("3. Track Parcel");
            System.out.println("4. Show All Parcels");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    updateParcel();
                    break;
                case 3:
                    trackParcel();
                    break;
                case 4:
                    showAllParcels();
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    // Add Parcel
    public static void addParcel() {
        System.out.print("Enter Parcel ID: ");
        String id = sc.next();

        if (findParcel(id) != null) {
            System.out.println("Parcel ID already exists!");
            return;
        }

        Parcel p = new Parcel(id);
        parcelList.add(p);
        System.out.println("Parcel added successfully!");
    }

    // Update Status
    public static void updateParcel() {
        System.out.print("Enter Parcel ID: ");
        String id = sc.next();

        Parcel p = findParcel(id);

        if (p == null) {
            System.out.println("Parcel not found!");
            return;
        }

        System.out.println("Select new status:");
        System.out.println("1. In Transit");
        System.out.println("2. Delivered");

        int ch = sc.nextInt();

        switch (ch) {
            case 1:
                p.updateStatus("In Transit");
                break;
            case 2:
                p.updateStatus("Delivered");
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        System.out.println("Status updated successfully!");
    }

    // Track Parcel
    public static void trackParcel() {
        System.out.print("Enter Parcel ID: ");
        String id = sc.next();

        Parcel p = findParcel(id);

        if (p == null) {
            System.out.println("Parcel not found!");
        } else {
            p.showDetails();
        }
    }

    // Show All Parcels
    public static void showAllParcels() {
        if (parcelList.isEmpty()) {
            System.out.println("No parcels available.");
            return;
        }

        System.out.println("\nAll Parcels:");
        for (Parcel p : parcelList) {
            System.out.println(p.getParcelId() + " - " + p.getStatus());
        }
    }

    // Find Parcel by ID
    public static Parcel findParcel(String id) {
        for (Parcel p : parcelList) {
            if (p.getParcelId().equals(id)) {
                return p;
            }
        }
        return null;
    }
}