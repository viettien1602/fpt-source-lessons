
import java.util.Scanner;

public class ReverseInt {
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

    void reverse() {
        int reverseNum = 0;
        while (num > 0) {
            reverseNum = (reverseNum * 10) + (num % 10);
            num /= 10;
        }
        System.out.println("Reverse number is: " + reverseNum);
    }
}
