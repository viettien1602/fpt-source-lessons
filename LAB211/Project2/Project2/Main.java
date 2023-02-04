package Project2;


public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.add("Show all injection information.");
        menu.add("Show students injected only 1 dose.");
        menu.add("Show students injected 2 doses.");
        menu.add("Show students who haven't been injected.");
        menu.add("Search student info by student ID.");
        menu.add("Add new injection info.");
        menu.add("Update injection info.");
        menu.add("Delete injection info.");
        menu.add("Quit");

        InjList list = new InjList();
        String fname = "Vaccinations.txt";
        list.loadFromFile(fname);

        int choice;
        System.out.println("Welcome to Covid-19 Vaccine Management - @ 2021 by <SE161204 - Ngo Viet Tien >");
        while (true) {
            System.out.println("=============================================================================");
            choice = menu.getUserChoice();
            switch(choice) {
                case 1:
                    list.showAll();
                    break;
                case 2:
                    list.showStudentsWithoutInj2();
                    break;
                case 3:
                    list.showStudentsWithInj2();
                    break;
                case 4:
                    list.showStudentsWithoutInj();
                    break;
                case 5:
                    list.searchInfoBySID();
                    break;
                case 6:
                    list.addNewInj();
                    list.saveToFile(fname);
                    break;
                case 7:
                    list.update();
                    list.saveToFile(fname);
                    break;
                case 8:
                    list.deleteInj();
                    list.saveToFile(fname);
                    break;
                case 9:
                    System.out.println("Goodbye.");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
    }
}
