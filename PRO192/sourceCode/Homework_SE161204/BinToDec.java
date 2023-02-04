
import java.util.Scanner;

public class BinToDec {
    //properties
    long bin;

    //methods
    void input() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Input a binary number: ");
            bin = input.nextLong();
        }
        while (validate(bin) == 0);
    }

    int validate(long copy) {
        while (copy > 0) {
            if (copy % 10 != 0 && copy % 10 != 1) return 0;
            copy /= 10;
        }
        return 1;
    }

    void convert() {
        long dec = 0;
        int i = 0;
        while (bin > 0) {
            dec += (bin % 10) * (long)Math.pow(2, i);
            i++;
            bin /= 10;
        }
        System.out.println("The decimal value is " + dec);
    }

}
