package Project2;

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
                if (n < 0) throw new Exception("Negative int.");
                valid = true;
            }
            catch (Exception e) {
                System.out.print("Invalid int. Input again: ");
            }
        }
        while (!valid);
        return n;
    }

    public static String validString() {
        String s = "";
        boolean valid = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                s = sc.nextLine().toUpperCase().trim();
                if (s.equals("")) throw new Exception("Empty string.");
                valid = true;
            }
            catch(Exception e) {
                System.out.println("Invalid string. Input again: ");
            }
        }
        while(!valid);
        return s;
    }

    public static String validStringWithBlank() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().toUpperCase().trim();
    }

    public static Date validDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = null;
        Date currentDate = new Date();
        Date importVcDate = null;
        try {
            importVcDate = sdf.parse("01/05/2021");
        }
        catch(Exception e) {
            System.out.println(e);
        }

        boolean valid = false;
        sdf.setLenient(false);
        do {
            try {
                Scanner sc = new Scanner(System.in);
                d = sdf.parse(sc.nextLine().trim());
                if (d.compareTo(currentDate) >= 0 || d.compareTo(importVcDate) < 0)
                    throw new Exception("Invalid.");
                valid = true;
            }
            catch(Exception e) {
                System.out.print("Invalid date. Input again: ");
            }
        }
        while(!valid);
        return d;
    }

    public static char validYorN() {
        char c = ' ';
        boolean valid = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                c = sc.nextLine().toUpperCase().trim().charAt(0);
                if (c != 'Y' && c != 'N')
                    throw new Exception("Not Y or N");
                valid = true;
            }
            catch(Exception e) {
                System.out.print("Invalid choice. Choose again: ");
            }
        }
        while (!valid);
        return c;
    }

}
