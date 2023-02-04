package Project1;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.lang.Comparable;

public class Food implements Comparable {
    String id, name, type, place;
    int weight;
    Date expiredD;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void input() {
        System.out.print("Name: ");
        name = ValidateInp.validName();
        System.out.print("Type: ");
        type = ValidateInp.validName();
        System.out.print("Place (upper/middle/lower/bottom/door): ");
        place = ValidateInp.validPlace();
        System.out.print("Weight (gam): ");
        weight = ValidateInp.validInt();
        System.out.print("Expired date (dd/mm/yyyy): ");
        expiredD = ValidateInp.validDate();
    }

    public void output() {
        System.out.print(id + "\t" + name + "\t" + type + "\t" + place +
                        "\t" + weight + "\t\t" + sdf.format(expiredD));
        System.out.println();
    }

    public int compareTo(Object obj) {
        return -(this.expiredD.compareTo(((Food)obj).expiredD));
    }
    
}
