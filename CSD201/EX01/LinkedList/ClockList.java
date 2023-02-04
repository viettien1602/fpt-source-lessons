package LinkedList;

import java.util.LinkedList;
import java.util.Scanner;

public class ClockList extends LinkedList<Clock> {


    //Function: add a new clock
    public void addClock() throws Exception {
        Clock clk = new Clock();

        //Input data
        System.out.print("ID: ");
        clk.id = ValidInput.validString();
        while (searchId(clk.id) != -1) {
            System.out.print("Existed. ID: ");
            clk.id = ValidInput.validString();
        }
        clk.input();

        //Add to the list
        if (this.add(clk)) System.out.println("Added successfully.");
        else System.out.println("Added failed");
    }

    //Search a clock based on ID, return index;
    private int searchId(String id) {
        return this.indexOf(new Clock(id));
    }

    //Function: remove a clock based on ID
    public void removeClock() throws Exception {
        if (this.size() == 0) {
            System.out.println("Empty list.");
            return;
        }

        String id;
        System.out.print("Input ID of the clock to remove: ");
        id = ValidInput.validString();
        int pos = searchId(id);
        if (pos == -1) System.out.println("Not found.");
        else {
            this.remove(pos);
            System.out.println("Clock " + id + " was deleted.");
        }
    }

    //Function: update a clock based on ID
    public void updateClock() throws Exception {
        if (this.size() == 0) {
            System.out.println("Empty list.");
            return;
        }

        String id;
        System.out.print("Input ID of the clock to update: ");
        id = ValidInput.validString();
        int pos = searchId(id);
        if (pos == -1) System.out.println("Not found.");
        else {
            Clock obj = this.get(pos);
            String updateId;
            System.out.print("ID: ");
            updateId = ValidInput.validString();
            while (searchId(updateId) != -1 && searchId(updateId) != pos) {
                System.out.print("Existed. ID: ");
                updateId = ValidInput.validString();
            }
            obj.id = updateId;
            obj.input();
            System.out.println("Clock " + id + " was updated.");
        }
    }

    //Function: list all clocks
    public void print() {
        if (this.size() == 0) {
            System.out.println("Empty list.");
            return;
        }

        for (Clock x : this) System.out.println(x);
    }

    public void printPrice() throws Exception {
        if (this.size() == 0) {
            System.out.println("Empty list.");
            return;
        }

        //Input 2 price
        int price1, price2;
        System.out.println("Input price range: ");
        System.out.print("Price 1: ");
        price1 = ValidInput.validInt();
        System.out.print("Price 2: ");
        price2 = ValidInput.validInt();

        if (price1 > price2) {
            int temp = price1;
            price1 = price2;
            price2 = temp;
        }

        for (Clock clk : this) {
            if ((clk.price >= price1) && (clk.price <= price2)) {
                System.out.println(clk);
            }
        }
    }

    //End of the class ClockList

}
