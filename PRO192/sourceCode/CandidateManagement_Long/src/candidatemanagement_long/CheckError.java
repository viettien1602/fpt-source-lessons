/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidatemanagement_long;

import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author LongDinh
 */
public class CheckError {

    public static boolean Check_Valid_Num(String num_) {
        try {
            num_.equals("");
            Integer.parseInt(num_);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean Check_Name(String s) {
        if (s.equals("")) {
            return false;
        } else {
            String[] arr = s.split(" ");
            for (int i = 0; i < arr.length; i++) {
                String che = arr[i];
                for (int j = 0; j < che.length(); j++) {
                    if (Character.isLetter(che.charAt(j)) == false) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean Check_Month_Valid(String s) {
        String[] check_ = s.split("/");
        int[] check = new int[check_.length];
        for (int i = 0; i < check.length; i++) {
            check[i] = Integer.parseInt(check_[i]);
        }
        if (check_[2].length() < 4) return false;
        else if (check[1] > 12 || check[1] < 1) {
            return false;
        } else if (check[1] == 1 || check[1] == 3 || check[1] == 5 || check[1] == 7 || check[1] == 8 || check[1] == 10 || check[1] == 12) {
            if (check[0] > 31) {
                return false;
            }
        } else if (check[1] == 4 || check[1] == 6 || check[1] == 9 || check[1] == 11) {
            if (check[0] > 30) {
                return false;
            }
        } else if (check[1] == 2) {
            if (check[0] == 29) {
                if (check[2] % 4 != 0 || check[2] % 100 == 0 && check[2] % 400 != 0) {
                    return false;
                }
            } else if (check[0] > 28) {
                return false;
            }
        }
        return true;
    }

    public static boolean Check_Date(String c) {
        try {
            Date cc = new Date(c);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validMail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static boolean isValidFutureDate(String futureDate) {
        String date[] = futureDate.split("/");
        int day = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);
        LocalDate today = LocalDate.now();
        return today.isBefore(LocalDate.of(year, month, day));
    }
}
