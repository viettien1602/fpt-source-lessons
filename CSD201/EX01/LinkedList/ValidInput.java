package LinkedList;

import java.util.Scanner;

public class ValidInput {

    public static int validInt() throws Exception {
        int n = 0;
        boolean valid = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                n = sc.nextInt();
                if (n < 0) throw new Exception("Negative");
                valid = true;
            } catch (Exception e) {
                System.out.print("Invalid. Input again: ");
            }
        }
        while (!valid);
        return n;
    }

    public static String validString() throws Exception {
        String s = "";
        boolean valid = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                s = sc.nextLine().toUpperCase().trim();
                if (s.equals("")) {
                    throw new Exception("Empty string");
                }
                int countSpace = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == ' ') countSpace++;
                }
                if (countSpace == s.length()) {
                    throw new Exception("All space string");
                }
                valid = true;
            }
            catch(Exception e) {
                System.out.print("Invalid. Input again: ");
            }
        }
        while (!valid);
        return s;
    }


}
