package Project1;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class ValidateInp {

    public static int validInt() {
        int n = 0;
        boolean valid = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                n = sc.nextInt();
                if (n < 0) throw new Exception("Negative Int.");
                valid = true;
            }
            catch (Exception e) {
                System.out.print("Invalid. Input again: ");
            }
        }
        while (!valid);
        return n;
    }

    public static String validName() {
        String s = "";
        boolean valid = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                s = sc.nextLine().toUpperCase().trim();
                if (s.equals("")) throw new Exception("Empty string.");
                for (int i = 0; i < s.length(); i++) {
                    if ((s.charAt(i) < 'A' || s.charAt(i) > 'Z') && s.charAt(i) != ' ')
                        throw new Exception("Not name.");
                }
                String[] str = s.split(" ");
                if (str.length == 0) throw new Exception("All space string.");
                valid = true;
            }
            catch (Exception e) {
                System.out.print("Invalid. Input again: ");
            }
        }
        while (!valid);
        return s;
    }

    public static String validString() {
        String s = "";
        boolean valid = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                s = sc.nextLine().toUpperCase().trim();
                if (s.equals("")) throw new Exception("Empty string.");
                String[] str = s.split(" ");
                if (str.length == 0) throw new Exception("All space string.");
                valid = true;
            }
            catch (Exception e) {
                System.out.print("Invalid. Input again: ");
            }
        }
        while (!valid);
        return s;
    }

    public static String validPlace() {
        String s = "";
        boolean valid = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                s = sc.nextLine().toUpperCase().trim();
                if (!s.equals("UPPER") && !s.equals("MIDDLE") && !s.equals("LOWER") &&
                    !s.equals("BOTTOM") && !s.equals("DOOR"))
                    throw new Exception("Not place.");
                valid = true;
            }
            catch (Exception e) {
                System.out.print("Invalid. Input again: ");
            }
        }
        while (!valid);
        return s;
    }

    public static Date validDate() {
        Date d = new Date();
        Date now = new Date();
        String checkingDate = "";
        boolean valid = false;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        do {
            try {
                Scanner sc = new Scanner(System.in);
                checkingDate = sc.nextLine().trim();
                d = sdf.parse(checkingDate);
                if (d.compareTo(now) <= 0) throw new Exception("<= now.");
                valid = true;
            }
            catch (Exception e) {
                System.out.print("Invalid. Input again: ");
            }
        }
        while (!valid);
        return d;
    }

    public static char validYN() {
        char c = ' ';
        boolean valid = false;

        do {
            try {
                Scanner sc = new Scanner(System.in);
                c = sc.nextLine().toUpperCase().trim().charAt(0);
                if (c != 'Y' && c != 'N') throw new Exception("Not Y or N.");
                valid = true;
            }
            catch(Exception e) {
                System.out.print("Invalid. Input again: ");
            }
        }
        while (!valid);
        return c;
    }
}
