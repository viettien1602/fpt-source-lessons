package stk_que;

import java.util.Stack;

public class Converter {
    public static String convert(int n, int base) {
        String result = "";
        //Push remainders to stack
        Stack<Integer>stk = new Stack<>();
        do {
            stk.push(n % base);
            n /= base;
        }
        while (n > 0);

        //Pop values in stack then concatenate it to the result
        while (!stk.empty()) {
            int value = stk.pop();
            result += Character.forDigit(value, base); //digit in base system
        }
        return result.toUpperCase();
    }

    public static void main(String[] args) {
        int n = 106;
        System.out.println("n = " + convert(n, 2) + "b");
        System.out.println("n = " + convert(n, 8) + "q");
        System.out.println("n = " + convert(n, 10) + "d");
        System.out.println("n = " + convert(n, 16) + "h");
    }
}
