package Project2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Injection {
    String injID, sID, sName, vID, vName, place1, place2;
    Date d1, d2;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Injection() {
        injID = "";
        sID = "";
        sName = "";
        vID = "";
        vName = "";
        place1 = "";
        place2 = "";
        d1 = null;
        d2 = null;
    }

    public String outputOneWithoutInj2() {
        return "--- " + injID + "," + sID + "," + sName + ","
                + vID + "," + vName + "," + place1 + "," + sdf.format(d1);
    }

    public String outputOneWithInj2() {
        return "--- " + injID + "," + sID + "," + sName + ","
                + vID + "," + vName + "," + place1 + "," + sdf.format(d1)
                + "," + place2 + "," + sdf.format(d2);
    }
}
