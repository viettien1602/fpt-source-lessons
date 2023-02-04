package llpkg;

public class MySortedLL_Test {
    public static void main(String[] args) {
        MySortedLL list = new MySortedLL();
        list.add(9, 5, 1, 2, 8, 6, 7, 3, 4, 0);
        //print the list for testing
        MyIterator iterator = list.iterator();
        while (iterator.hasNext()) System.out.print(iterator.next() + ", ");
        System.out.println();

        //Test search operation
        LL_Element result = list.search(8);
        if (result != null) System.out.println("8 existed.");
        else System.out.println("8 doesn't exist in the list.");

        //Test remove operation
        list.remove(8);
        System.out.println("8 is removed");
        iterator = list.iterator();
        while (iterator.hasNext()) System.out.print(iterator.next() + ", ");
        System.out.println();
    }
}
