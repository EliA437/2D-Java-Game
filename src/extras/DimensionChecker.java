package src.extras;
import java.util.ArrayList;
import java.util.Scanner;

public class DimensionChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // GAIN INFO
        System.out.print("Enter desired width: ");
        int intWidth = scanner.nextInt();
        System.out.print("Enter desired height: ");
        int intHeight = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Should be: " + (intWidth * intHeight));

        // ABSORB NUMBERS
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println("Paste map here (Enter an empty line to stop): ");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break; // Stop input on empty line
            String[] parts = line.split("\\s+"); // Split by spaces
            for (String part : parts) {
                arrayList.add(part);
            }
        }
        scanner.close();

        // CHECK TOTAL COUNT
        int total = arrayList.size();
        System.out.println("Total: " + total);
        if (total == intWidth * intHeight) {
            System.out.println("Correct dimensions!");
        } else {
            System.out.println("Mismatch! Expected: " + (intWidth * intHeight) + ", but got: " + total);
        }
    }
}
