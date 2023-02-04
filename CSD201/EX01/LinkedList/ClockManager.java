package LinkedList;

public class ClockManager {
    public static void main(String[] args) throws Exception {
        //Set up menu
        Menu menu = new Menu();
        menu.add("Add a new clock.");
        menu.add("Remove a clock.");
        menu.add("Update a clock.");
        menu.add("List all clocks.");
        menu.add("List all clocks in a range.");
        menu.add("Quit.");

        //Create linked list of clocks
        ClockList list = new ClockList();
        int choice;
        while (true) {
            choice = menu.getUserChoice();
            switch(choice) {
                case 1:
                    list.addClock();
                    break;
                case 2:
                    list.removeClock();
                    break;
                case 3:
                    list.updateClock();
                    break;
                case 4:
                    list.print();
                    break;
                case 5:
                    list.printPrice();
                    break;
                case 6:
                    System.out.println("Goodbye.");
                    return;
                default:
                    System.out.println("Invalid operation.");
                    break;
            }
        }
    }
}
