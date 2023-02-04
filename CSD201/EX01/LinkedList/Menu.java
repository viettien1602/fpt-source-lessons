package LinkedList;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends ArrayList {
    public int getUserChoice() throws Exception {
        for (int i = 0; i < this.size(); i++) {
            System.out.println((i + 1) + "-" + this.get(i));
        }
        System.out.print("Choose an option: ");
        return ValidInput.validInt();
    }
}
