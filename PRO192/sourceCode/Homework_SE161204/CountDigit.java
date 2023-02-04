
import java.util.Scanner;

public class CountDigit {
    //properties
    int num;

    //methods
    void input() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Input a positive integer: ");
            num = input.nextInt();
        }
        while (num < 0);
    }

    void count() {
        int i = 0;
        do {
            i++;
            num /= 10;
        } while (num > 0);
        System.out.println("Number of digits: " + i);
    }
}
