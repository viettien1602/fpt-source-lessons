package Project2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StudentList extends ArrayList<Student> {

    public StudentList() {
        this.loadFromFile("Students.txt");
    }

    public void loadFromFile(String fname) {
        try {
            File f = new File(fname);
            if (!f.exists()) {
                System.out.println("File " + fname + "doesn't exist.");
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(line, ",");
                Student stu = new Student();
                stu.sID = stk.nextToken().trim();
                stu.sName = stk.nextToken().trim();
                this.add(stu);
            }
            br.close();
            fr.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public void showStudents() {
        System.out.println("Choose students from the list below: ");
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i).sID + ": " + this.get(i).sName);
        }
    }

    public int findID(String id) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).sID.equals(id)) return i;
        }
        return -1;
    }

}
