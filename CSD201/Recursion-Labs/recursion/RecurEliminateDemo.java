package recursion;

import java.util.Stack;

public class RecurEliminateDemo {
    //Recursive version
    public static String cur_convert(int n, int base) {
        if (n == 0) return "";
        return cur_convert(n / base, base) + Character.forDigit(n % base, base);
    }

    //loop version: using a string as a stack
    public static String convert2(int n, int base) {
        String result = "";
        do {
            result = Character.forDigit(n % base, base) + result;
            n /= base;
        }
        while (n > 0);
        return result;
    }

    //loop version: Using library stack
    public static String convert3(int n, int base) {
        Stack<Character> stk = new Stack<>();
        do {
            stk.push(Character.forDigit(n % base, base));
            n /= base;
        }
        while (n > 0);
        String result = "";
        while (!stk.isEmpty()) {
            result += stk.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("10 - base: " + cur_convert(122, 10));
        System.out.println("2 - base: " + cur_convert(122, 2));
        System.out.println("8 - base: " + cur_convert(122, 8));
        System.out.println("16 - base: " + cur_convert(122, 16));
        String s1 = cur_convert(122, 16);
        String s2 = convert2(122, 16);
        String s3 = convert3(122, 16);
        System.out.println(s1 + ", " + s2 + ", " + s3);
    }

}
