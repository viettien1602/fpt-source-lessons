
import java.util.Scanner;

public class DecToBin {
    //properties
    int dec;

    //methods
    void input() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Input a positive decimal number: ");
            dec = input.nextInt();
        }
        while (dec < 0);
    }

    void convert() {
        long bin = 0;
        int i = 0;
        while (dec > 0) {
            bin += (dec % 2) * (long)Math.pow(10, i);
            i++;
            dec /= 2;
        }
        System.out.println("The binary value is: " + bin);
    }

}
