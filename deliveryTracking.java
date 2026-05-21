import java.util.Scanner;

public class DeliveryTracking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String parcelId = "";
        String status = "No Parcel";

        int choice;

        do {

            System.out.println("\n1. Add Parcel");
            System.out.println("2. Update Status");
            System.out.println("3. Track Parcel");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.print("Enter Parcel ID: ");
                    parcelId = sc.next();
                    status = "Dispatched";
                    System.out.println("Parcel Added");
                    break;

                case 2:
                    status = "Delivered";
                    System.out.println("Status Updated");
                    break;

                case 3:
                    System.out.println("Parcel ID: " + parcelId);
                    System.out.println("Status: " + status);
                    break;

                case 4:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while(choice != 4);
    }
}
