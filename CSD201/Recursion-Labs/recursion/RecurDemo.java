package recursion;

public class RecurDemo {
    //computing n!
    public static double factorial(int n) {
        if (n < 2) return 1;
        return n * factorial(n - 1);
    }

    //computing Fibonacci number
    public static int fibo(int n) {
        if (n < 2) return 1;
        return fibo(n - 1) + fibo(n - 2);
    }

    //testing whether x is in Fibonacci number or not
    public static boolean testFibo(int n) {
        if (n < 1) return false;
        int aFibo = 1;;
        int index = 2;
        while (aFibo < n) aFibo = fibo(index++);
        return aFibo == n;
    }

    //computing arithmetic progression
    public static double ap(int n, double a, double d) {
        if (n == 1) return a;
        return ap(n - 1, a, d) + d;
    }

    //computing geometric progression
    public static double gp(int n, double a, double d) {
        if (n == 1) return a;
        return gp(n - 1, a, d) * d;
    }

    //calculate sum of integral array having n elements
    public static double sum(double[] a, int n) {
        if (n == 0) return 0;
        return a[n - 1] + sum(a, n - 1);
    }

    //Calculate the maximum value in an integral array having n elements
    public static double max(int[] a, int n) {
        if (n == 1) return a[0];
        double m = max(a, n - 1);
        return m > a[n - 1] ? m : a[n - 1];
    }

    //Calculate the minimum value in an integral array having n elements
    public static double min(int[] a, int n) {
        if (n == 1) return a[0];
        double m = min(a, n - 1);
        return m < a[n - 1] ? m : a[n - 1];
    }

    //Convert a decimal integer to a numeric string in specific base number system
    public static String convert(int n, int base) {
        if (n == 0) return "";
        return convert(n / base, base) + Character.forDigit(n % base, base);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(fibo(10));
        System.out.println(testFibo(144));
        System.out.println(testFibo(120));
        System.out.println(ap(6, 1.5, 2));
        System.out.println(gp(6, 1.5, 2));
        double[] a = {1.5, 2, 4, 5, 2, 6.5};
        System.out.println(sum(a, 6));
        int[] b = {1, 5, 9, 7, 2, 19, 10};
        System.out.println(max(b, 7));
        System.out.println(min(b, 7));
        System.out.println("Binary: " + convert(266, 2));
        System.out.println("Decimal: " + convert(266, 10));
        System.out.println("Octal: " + convert(266, 8));
        System.out.println("Hexadecimal: " + convert(266, 16));
    }

}
