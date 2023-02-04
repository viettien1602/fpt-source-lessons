
import java.util.Scanner;

public class Menu {

    public static void menu() {
        System.out.println("1. Convert binary number to decimal.");
        System.out.println("2. Convert decimal number to binary.");
        System.out.println("3. Create multiplication from 1 to 9.");
        System.out.println("4. Count number of digits in an integer.");
        System.out.println("5. Reverse an integer.");
        System.out.println("6. Exit.");
        System.out.println("=========================================");
        System.out.print("Choose an operation: ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            Menu.menu();
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    BinToDec obj1 = new BinToDec();
                    obj1.input();
                    obj1.convert();
                    break;

                case 2:
                    DecToBin obj2 = new DecToBin();
                    obj2.input();
                    obj2.convert();
                    break;

                case 3:
                    MultiOnetoNine obj3 = new MultiOnetoNine();
                    obj3.show();
                    break;

                case 4:
                    CountDigit obj4 = new CountDigit();
                    obj4.input();
                    obj4.count();
                    break;

                case 5:
                    ReverseInt obj5 = new ReverseInt();
                    obj5.input();
                    obj5.reverse();
                    break;

                case 6:
                    System.out.println("Goodbye !");
                    return;

                default:
                    System.out.println("Invalid operation ! Please choose again !");
                    break;

            }

        }

    }


}
