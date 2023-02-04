package Project2;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

public class InjList extends ArrayList<Injection> {
    StudentList stuList;
    VaccineList vcList;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public InjList() {
        stuList = new StudentList();
        vcList = new VaccineList();
    }

    public void loadFromFile(String fname) {
        try {
            File f = new File(fname);
            if (!f.exists()) {
                System.out.println("File " + fname + " doesn't exist.");
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            String temp;
            while ((line = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(line, ",");
                Injection inj = new Injection();
                inj.injID = stk.nextToken().trim();
                inj.sID = stk.nextToken().trim();
                inj.sName = stuList.get(stuList.findID(inj.sID)).sName;
                inj.vID = stk.nextToken().trim();
                inj.vName = vcList.get(vcList.findID(inj.vID)).vName;
                inj.place1 = stk.nextToken();
                inj.d1 = sdf.parse(stk.nextToken());
                if (line.split(",").length == 7) {
                    inj.place2 = stk.nextToken().trim();
                    inj.d2 = sdf.parse(stk.nextToken());
                }
                this.add(inj);
            }
            br.close();
            fr.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public void saveToFile(String fname) {
        try {
            File f = new File(fname);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Injection inj : this) {
                if (inj.place2.equals(""))
                    pw.println(inj.injID + "," + inj.sID + "," + inj.vID + ","
                            + inj.place1 + "," + sdf.format(inj.d1));
                else
                    pw.println(inj.injID + "," + inj.sID + "," + inj.vID + ","
                            + inj.place1 + "," + sdf.format(inj.d1) + ","
                            + inj.place2 + "," + sdf.format(inj.d2));
            }
            pw.close();
            fw.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public void addNewInj() {
        String injID, sID, vID, place1, place2 = "";
        Date d1, d2 = null, currentDate = new Date();
        boolean valid;
        System.out.println("Adding a new injection info: (type \"/exit\" to quit)");
        //Input ID;
        do {
            System.out.print("+ Injection ID: ");
            injID = ValidateInp.validString();
            if (injID.equals("/EXIT")) return;
            if (findInjId(injID) != -1)
                System.out.println("Duplicate injection ID.");
        }
        while (findInjId(injID) != -1);

        //Input sID
        stuList.showStudents();
        valid = false;
        do {
            System.out.print("+ Student ID: ");
            sID = ValidateInp.validString();
            if (sID.equals("/EXIT")) return;
            if (stuList.findID(sID) == -1)
                System.out.println("Student ID must exist in the list above.");
            else if (findSId(sID) != -1)
                System.out.println("Student already existed in the Injection Information List.");
            else valid = true;
        }
        while (!valid);

        //Input vID
        vcList.showVaccines();
        valid = false;
        do {
            System.out.print("+ Vaccine ID: ");
            vID = ValidateInp.validString();
            if (vID.equals("/EXIT")) return;
            if (vcList.findID(vID) == -1)
                System.out.println("Vaccine ID must exist in the list above.");
            else valid = true;
        }
        while (!valid);

        //Input place1
        System.out.print("+ 1st injection place: ");
        place1 = ValidateInp.validString();
        if (place1.equals("/EXIT")) return;

        //Input d1
        System.out.print("+ 1st injection date: ");
        d1 = ValidateInp.validDate();

        //Input place2
        if (((currentDate.getTime() - d1.getTime()) / 86400000) >= 28) {
            System.out.print("+ 2nd injection place: ");
            place2 = ValidateInp.validStringWithBlank();
            if (place2.equals("/EXIT")) return;
        }


        //Input d2
        if (!place2.equals("")) {
            valid = false;
            do {
                System.out.print("+ 2nd injection date: ");
                d2 = ValidateInp.validDate();
                if (((d2.getTime() - d1.getTime()) / 86400000) < 28) {
                    System.out.println("The 2nd dose of vaccine must be at least 28 days after the 1st injection");
                }
                else valid = true;
            }
            while(!valid);
        }

        Injection inj = new Injection();
        inj.injID = injID;
        inj.sID =sID;
        inj.sName = stuList.get(stuList.findID(sID)).sName;
        inj.vID = vID;
        inj.vName = vcList.get(vcList.findID(vID)).vName;
        inj.place1 = place1;
        inj.d1 = d1;
        inj.place2 = place2;
        inj.d2 = d2;
        this.add(inj);
        showOneStudentInj(this.size() - 1);
        System.out.println("Adding successfully.");
    }

    private int findInjId(String id) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).injID.equals(id)) return i;
        }
        return -1;
    }

    private int findSId(String id) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).sID.equals(id)) return i;
        }
        return -1;
    }

    public void showAll() {
        if (this.size() == 0) {
            System.out.println("Empty list.");
            return;
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).place2.equals(""))
                System.out.println(this.get(i).outputOneWithoutInj2());
            else
                System.out.println(this.get(i).outputOneWithInj2());
        }
    }

    public void showStudentsWithoutInj2() {
        if (this.size() == 0) {
            System.out.println("Empty list.");
            return;
        }
        boolean having = false;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).place2.equals("")) {
                System.out.println(this.get(i).outputOneWithoutInj2());
                having = true;
            }
        }
        if (!having)
            System.out.println("There are no students in the list injected just 1 dose.");
    }

    public void showStudentsWithInj2() {
        if (this.size() == 0) {
            System.out.println("Empty list.");
            return;
        }
        boolean having = false;
        for (int i = 0; i < this.size(); i++) {
            if (!this.get(i).place2.equals("")) {
                System.out.println(this.get(i).outputOneWithInj2());
                having = true;
            }
        }
        if (!having)
            System.out.println("There are no students in the list injected 2 doses.");
    }

    public void showStudentsWithoutInj() {
        boolean having = false;
        for (Student stu : stuList) {
            if (findSId(stu.sID) == -1) {
                System.out.println(stu.toString());
                having = true;
            }
        }
        if (!having)
            System.out.println("All students have been injected.");
    }

    private int showOneStudentInj(int pos) {
        if (this.get(pos).place2.equals("")) {
            System.out.println("This student has just injected 1 dose of vaccine.");
            System.out.println(this.get(pos).outputOneWithoutInj2());
            return 1;
        }
        else {
            System.out.println("This student has injected 2 doses of vaccine.");
            System.out.println(this.get(pos).outputOneWithInj2());
            return 2;
        }
    }

    public void searchInfoBySID() {
        String searchSID;
        System.out.print("Student ID to find: ");
        searchSID = ValidateInp.validString();
        if (stuList.findID(searchSID) == -1) {
            System.out.println("Student ID not found.");
            return;
        }
        if (findSId(searchSID) == -1) {
            System.out.println("This student hasn't injected yet");
            System.out.println(stuList.get(stuList.findID(searchSID)).toString());
            return;
        }
        int pos = findSId(searchSID);
        int status = showOneStudentInj(pos);
    }

    public void update() {
        String updateInjID;
        System.out.print("Injection ID to update: ");
        updateInjID = ValidateInp.validString();
        if (findInjId(updateInjID) == -1) {
            System.out.println("Injection ID not found.");
            return;
        }
        int pos = findInjId(updateInjID);
        System.out.println("The information about injection ID \"" + updateInjID + "\":");
        int status = showOneStudentInj(pos);
        Injection inj = this.get(pos);
        char choice;
        Date currentDate = new Date();

        System.out.print("Do you want to modify 1st injection info (Y or N): ");
        choice = ValidateInp.validYorN();
        if (choice == 'Y') {
            //Input place1
            System.out.print("+ 1st injection place: ");
            inj.place1 = ValidateInp.validString();
            //Input d1
            System.out.print("+ 1st injection date: ");
            inj.d1 = ValidateInp.validDate();
        }
        if (status == 1) {
            if (((currentDate.getTime() - inj.d1.getTime()) / 86400000) < 28) {
                System.out.println("You can not add 2nd injection since the time between " +
                        "1st dose of vaccine and 2nd one is at least 28 days.");
            }
            else {
                System.out.print("Do you want to add 2nd injection info (Y or N): ");
                choice = ValidateInp.validYorN();
                if (choice == 'Y') {
                    //Input place 2
                    System.out.print("+ 2nd injection place: ");
                    inj.place2 = ValidateInp.validString();
                    //Input d2
                    boolean valid = false;
                    do {
                        System.out.print("+ 2nd injection date: ");
                        inj.d2 = ValidateInp.validDate();
                        if (((inj.d2.getTime() - inj.d1.getTime()) / 86400000) < 28) {
                            System.out.println("The 2nd dose of vaccine must be at least " +
                                    "28 days after the 1st injection");
                        }
                        else valid = true;
                    }
                    while(!valid);
                }
            }
        }
        else {
            choice = 'Y';
            while (choice == 'Y' && ((currentDate.getTime() - inj.d1.getTime()) / 86400000) < 28) {
                System.out.println("Your 2nd injection will be deleted since the time between " +
                        "1st dose of vaccine and 2nd one is at least 28 days.");
                System.out.print("Do you want to modify the date of 1st injection (Y or N): ");
                choice = ValidateInp.validYorN();
                if (choice == 'Y') {
                    //Change d1
                    System.out.print("+ 1st injection date: ");
                    inj.d1 = ValidateInp.validDate();
                }
            }
            if (choice == 'N') {
                inj.place2 = "";
                inj.d2 = null;
            }
            else {
                if (((inj.d2.getTime() - inj.d1.getTime()) / 86400000) < 28) {
                    System.out.println("You must modify 2nd injection info since the time between " +
                            "1st dose of vaccine and 2nd one is at least 28 days.");
                }
                else {
                    System.out.print("Do you want to modify 2nd injection info (Y or N): ");
                    choice = ValidateInp.validYorN();
                }
                if (choice == 'Y') {
                    //Input place 2
                    System.out.print("+ 2nd injection place: ");
                    inj.place2 = ValidateInp.validString();
                    //Input d2
                    boolean valid = false;
                    do {
                        System.out.print("+ 2nd injection date: ");
                        inj.d2 = ValidateInp.validDate();
                        if (((inj.d2.getTime() - inj.d1.getTime()) / 86400000) < 28) {
                            System.out.println("The 2nd dose of vaccine must be at least " +
                                    "28 days after the 1st injection");
                        }
                        else valid = true;
                    }
                    while(!valid);
                }
            }
        }
        System.out.println("Injection info after updating: ");
        showOneStudentInj(pos);
    }

    public void deleteInj() {
        String deleteInjId;
        System.out.print("Injection ID to delete: ");
        deleteInjId = ValidateInp.validString();
        if (findInjId(deleteInjId) == -1) {
            System.out.println("ID not found.");
            return;
        }
        int pos = findInjId(deleteInjId);
        System.out.println("The information about injection ID \"" + deleteInjId + "\":");
        int status = showOneStudentInj(pos);
        this.remove(pos);
        System.out.println("Deleted successfully.");
    }

}
