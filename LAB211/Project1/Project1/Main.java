package Project1;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.add("Add a new food.");
        menu.add("Search a food by name.");
        menu.add("Remove a food by ID.");
        menu.add("Print the food list in the descending order of expired date.");
        menu.add("Quit.");

        FoodList obj = new FoodList();
        String fname = "food.txt";
        obj.loadFromFile(fname);

        int choice;
        System.out.println("Welcome to Food Management - @ 2021 by <SE161204 - Ngo Viet Tien >");
        while (true) {
            System.out.println("==================================================================");
            choice = menu.getUserChoice();
            switch(choice) {
                case 1:
                    obj.add();
                    obj.sort();
                    obj.saveToFile(fname);
                    break;
                case 2:
                    obj.searchByName();
                    break;
                case 3:
                    obj.removeById();
                    obj.saveToFile(fname);
                    break;
                case 4:
                    obj.sort();
                    obj.print();
                    break;
                case 5:
                    System.out.println("Exit successfully.");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }

    }
}
