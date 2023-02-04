package Project2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class VaccineList extends ArrayList<Vaccine> {

    public VaccineList() {
        this.loadFromFile("Vaccines.txt");
    }

    public void loadFromFile(String fname) {
        try {
            File f = new File(fname);
            if (!f.exists()) {
                System.out.println("File" + fname + "doesn't exist.");
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(line, ",");
                Vaccine vc = new Vaccine();
                vc.vID = stk.nextToken().trim();
                vc.vName = stk.nextToken().trim();
                this.add(vc);
            }
            br.close();
            fr.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public void showVaccines() {
        System.out.println("Choose vaccines from the list below: ");
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i).vID + ": " + this.get(i).vName);
        }
    }

    public int findID(String id) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).vID.equals(id)) return i;
        }
        return -1;
    }
}
