package maze;

public class Cell {
    public static char EMPTY_VAL = '0', BLOCKED = '1';
    int x, y;
    char value; //character in the cell
    boolean visited = false; //whether the cell is visited or not
    Cell previous = null; //for getting the path

    //Initiate a cell
    public Cell(int x, int y, char value) {
        this.x = x;
        this.y = y;;
        this.value = value;
    }
    //Checking this cell can be moved to or not
    public boolean canMoveTo() {
        return (!visited && value != BLOCKED);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + value + ")";
    }
}//Cell class
