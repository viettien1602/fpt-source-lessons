package Project2;

import java.util.ArrayList;

public class Menu extends ArrayList<String> {
    public int getUserChoice() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println((i + 1) + " - " + this.get(i));
        }
        System.out.print("Choose an option: ");
        return ValidateInp.validInt();
    }
}
