package candidatemanagement_long;
import java.util.Scanner;
import java.util.Formatter;
/**
 *
 * @author LongDinh
 */
public class CandidateManagement_Long {
    static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create file
        /*try {
            Formatter tao = new Formatter("Fresher.txt");
            System.out.println("Done");
        }catch (Exception e){
            System.out.println("Error");
        }*/
        ManageCandidate function = new ManageCandidate();
        function.takeInfofromFile1();
        function.takeInfofromFile2();
        function.takeInfofromFile3();
        boolean option = true;
        while (option==true) {
            int choice = 0;
            System.out.println("\u001b[33m╔══════════════╗\n║\u001B[31mCandidate\u001B[0m  Management \u001B[33m║\u001B[0m\n\u001B[33m╠══════════════╝\u001B[0m");
            System.out.print("\u001B[33m╠════════╗\u001B[0m\n\u001B[33m║\u001B[0m  \u001B[35mInsert  (1)\u001B[0m      \u001B[33m║\u001B[0m\n\u001B[33m║\u001B[0m  \u001B[36mFind  (2)\u001B[0m        \u001B[33m║\u001B[0m\n\u001B[33m║\u001B[0m\u001B[32m  Delete  (3)\u001B[0m     \u001B[33m║\u001B[0m\n\u001B[33m║\u001B[0m  \u001B[34mUpdate  (4) \u001B[0m   \u001B[33m║\u001B[0m\n\u001B[33m║\u001B[0m  \u001B[30mExit  (5)\u001B[0m         \u001B[33m║\u001B[0m\n\u001B[33m╠════════╝\u001B[0m\n\u001B[33m╠═╡\u001B[0m \u001B[31mChoice\u001B[0m: ");
            String choice_ = sc.nextLine();
            while (choice_!=null) {
                if (CheckError.Check_Valid_Num(choice_) == false) {
                    System.out.print("\u001B[33m╠═╡\u001B[0m\u001B[31m**Invalid input! Try again! Choice\u001B[0m: ");
                    choice_ = sc.nextLine();
                }else if (Integer.parseInt(choice_) < 1 || Integer.parseInt(choice_)>5) {
                    System.out.print("\u001B[33m╠═╡\u001B[0m\u001B[31m**Out of this operator! Try again! Choice\u001B[0m: ");
                    choice_ = sc.nextLine();
                }
                else {
                    choice = Integer.parseInt(choice_);
                    break;
                }
            }
            System.out.println("\u001B[33m╚═══════════════════════════╛\u001B[0m");
            switch(choice) {
                case 1:
                    function.addCan();
                    break;
                case 2:
                    if (function.size() < 1) System.out.println("-*\u001B[31mThere is no data! Please insert one\u001B[0m*-");
                    else function.findCan();
                    break;
                case 3:
                    if (function.size() < 1) System.out.println("-*\u001B[31mThere is no data! Please insert one\u001B[0m*-");
                    else function.deleteCan();
                    break;
                case 4:
                    if (function.size() < 1) System.out.println("-*\u001B[31mThere is no data! Please insert one\u001B[0m*-");
                    else function.modifyCan();
                    break;
                case 5:
                    option = false;
                    break;
            }
        }
        function.writeInfotoFile();
    }
}