import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Flames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Name: ");
        String name1 = sc.nextLine().toLowerCase().replaceAll("\\s", "");
        System.out.print("Enter Second Name: ");
        String name2 = sc.nextLine().toLowerCase().replaceAll("\\s", "");

        // 1. Remove common characters
        StringBuilder sb1 = new StringBuilder(name1);
        StringBuilder sb2 = new StringBuilder(name2);

        for (int i = 0; i < sb1.length(); i++) {
            for (int j = 0; j < sb2.length(); j++) {
                if (sb1.charAt(i) == sb2.charAt(j)) {
                    sb1.deleteCharAt(i);
                    sb2.deleteCharAt(j);
                    i--; // Step back to handle the new index after deletion
                    break;
                }
            }
        }

        int totalCount = sb1.length() + sb2.length();
        

        // 2. Perform FLAMES logic
        String result = getFlamesResult(totalCount);
        System.out.println("Relationship status: " + result);
        
        sc.close();
    }

    public static String getFlamesResult(int count) {
        if (count == 0) return "No relationship found (Count is 0)";

        List<String> flames = new ArrayList<>();
        flames.add("Friends");
        flames.add("Lovers");
        flames.add("Affection");
        flames.add("Marriage");
        flames.add("Enemies");
        flames.add("Siblings");

        int removeIdx = 0;
        while (flames.size() > 1) {
            // Formula to find the index to remove in a circular list
            removeIdx = (removeIdx + count - 1) % flames.size();
            flames.remove(removeIdx);
        }

        return flames.get(0);
    }
}