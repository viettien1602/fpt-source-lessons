package Project1;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class FoodList {
    ArrayList<Food> list = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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
            while ((line = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(line, ",");
                Food obj = new Food();
                obj.id = stk.nextToken().toUpperCase();
                obj.name = stk.nextToken().toUpperCase();
                obj.type = stk.nextToken().toUpperCase();
                obj.place = stk.nextToken().toUpperCase();
                obj.weight = Integer.parseInt(stk.nextToken().trim());
                obj.expiredD = sdf.parse(stk.nextToken().trim());
                list.add(obj);
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
            for (Food x : list) {
                pw.println(x.id + "," + x.name + "," + x.type + "," +
                            x.place + "," + x.weight + "," + sdf.format(x.expiredD));
            }
            pw.close();
            fw.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void print() {
        if (list.size() == 0) {
            System.out.println("Empty list.");
            return;
        }
        System.out.println(">>               - FOOD LIST -               <<");
        System.out.println("-----------------------------------------------");
        for (Food x : list) x.output();
        System.out.println("-----------------------------------------------");
    }

    private int findId(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id.equals(id)) return i;
        }
        return -1;
    }

    private int findName(String name, int index) {
        for (int i = index; i < list.size(); i++) {
            if (list.get(i).name.equals(name)) return i;
        }
        return -1;
    }

    public void add() {
        System.out.println("Add information for a food:");
        Food obj = new Food();
        do {
            System.out.print("ID: ");
            obj.id = ValidateInp.validString();
            if (findId(obj.id) != -1) System.out.println("Existed.");
        }
        while (findId(obj.id) != -1);
        obj.input();
        list.add(obj);
        System.out.println("Adding successfully.");
    }

    public void searchByName() {
        if (list.size() == 0) {
            System.out.println("Empty list.");
            return;
        }
        System.out.print("Input name to search: ");
        String name = ValidateInp.validName();
        int pos = findName(name, 0);
        if (pos == -1) System.out.println("Name not found.");
        else {
            list.get(pos).output();
            int index = pos + 1;
            while ((pos = findName(name, index)) != -1) {
                list.get(pos).output();
                index = pos + 1;
            }
        }
    }

    public void removeById() {
        if (list.size() == 0) {
            System.out.println("Empty list.");
            return;
        }
        System.out.print("Input ID to remove: ");
        String id = ValidateInp.validString();
        int pos = findId(id);
        if (pos == -1) System.out.println("ID not found.");
        else {
            System.out.println("Information about food " + id + ":");
            list.get(pos).output();
            System.out.print("Do you want to remove it ?(Y/N) ");
            char c = ValidateInp.validYN();
            if (c == 'Y') {
                list.remove(pos);
                System.out.println("Removing successfully.");
            }
        }
    }

    public void sort() {
        Collections.sort(list);
    }
}
