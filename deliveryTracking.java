import java.util.ArrayList;
import java.util.Scanner;

public class DeliveryTracking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> parcelIds = new ArrayList<>();
        ArrayList<String> statusList = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n1. Add Parcel");
            System.out.println("2. Update Status");
            System.out.println("3. Track Parcel");
            System.out.println("4. Show All Parcels");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Parcel ID: ");
                    String id = sc.next();

                    parcelIds.add(id);
                    statusList.add("Dispatched");

                    System.out.println("Parcel Added Successfully!");
                    break;

                case 2:
                    System.out.print("Enter Parcel ID: ");
                    id = sc.next();

                    int index = parcelIds.indexOf(id);

                    if (index != -1) {
                        statusList.set(index, "Delivered");
                        System.out.println("Status Updated!");
                    } else {
                        System.out.println("Parcel Not Found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Parcel ID: ");
                    id = sc.next();

                    index = parcelIds.indexOf(id);

                    if (index != -1) {
                        System.out.println("Parcel ID: " + parcelIds.get(index));
                        System.out.println("Status: " + statusList.get(index));
                    } else {
                        System.out.println("Parcel Not Found!");
                    }
                    break;

                case 4:
                    System.out.println("\nAll Parcels:");
                    for (int i = 0; i < parcelIds.size(); i++) {
                        System.out.println(parcelIds.get(i) + " - " + statusList.get(i));
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);

        sc.close();
    }
}
