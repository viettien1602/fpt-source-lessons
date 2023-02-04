package maze;

import java.io.File;
import java.io.FileReader;      //for reading character
import java.io.BufferedReader;  //for reading lines
import java.util.LinkedList;    //for stack
import java.util.ArrayList;     //for storing adjacent cells

public class Maze {
    public static char ENTRY_VAL = 'E', DEST_VAL = 'M';
    int rows = 0, cols = 0;     //size of the maze
    Cell[][] cells = null;      //map of the maze
    Cell entry = null;          //entry position of the maze: ENTRY_VAL
    Cell destination = null;    //exit cell or destination cell: DEST_VAL
    boolean completed = false;  //solving completed or not
    boolean succeeded = false;  //solving succeeded or not

    //checking validity of a coordinate
    private boolean valid(int x, int y) {
        return (x >= 0 && x < rows && y >= 0 && y < cols);
    }

    //Add adjacent cells of the curCell to an adjacency list
    //Update previous field
    private void add(Cell curCell, int x, int y, ArrayList<Cell> adjs) {
        Cell c;
        if (valid(x, y)) {      //checking coordinate
            c = cells[x][y];
            if (c.canMoveTo()) {
                c.previous = curCell;
                adjs.add(c);
            }
        }
    }

    //Getting adjacency cells of the current cell
    //There are 4 possible adjacencies
    private ArrayList<Cell> getAdjs(Cell curCell) {
        ArrayList<Cell> adjs = new ArrayList<>();
        int x = curCell.x, y = curCell.y;
        add(curCell, x - 1, y, adjs);   //add upper adjacency
        add(curCell, x + 1, y, adjs);   //add lower adjacency
        add(curCell, x, y - 1, adjs);   //add left adjacency
        add(curCell, x, y + 1, adjs);   //add right adjacency
        return adjs;
    }

    //Load a maze from a text file
    public boolean loadFromFile(String filename) {
        File f = new File(filename);
        if (!f.exists()) {      //cheking existence of the file
            System.out.println("The file " + filename + " doesn't  exist.");
            System.exit(0);
        }
        try {
            FileReader fr = new FileReader(f);              //reading characters
            BufferedReader bf = new BufferedReader(fr);     //reading lines
            ArrayList<String> list = new ArrayList<>();     //file to string list
            String line;
            while ((line = bf.readLine()) != null) {
                line = line.trim();     //normalizing each line
                if (line.length() > 0) list.add(line);
            }
            //Closing the file
            bf.close();
            fr.close();

            //Creating the matrix from the list
            this.rows = list.size();            //Determining rows
            this.cols = list.get(0).length();   //Determining cols
            this.cells = new Cell[rows][cols];  //Allocating memory of matrix

            for (int i = 0; i < list.size(); i++) {     //Creating cells
                line = list.get(i); //Getting a line : 101M1010101
                for (int j = 0; j < cols; j++) {        //Creating cells in the row i
                    char ch = line.charAt(j);
                    cells[i][j] = new Cell(i, j, ch);
                    //Determining the entry and destination of the maze
                    if (ch == ENTRY_VAL) this.entry = cells[i][j];
                    if (ch == DEST_VAL) this.destination = cells[i][j];
                }
            }
        }
        catch(Exception e) {
            System.out.println(e);
            System.exit(0);
        }
        return true;
    }   //loadFromFile(String filename)

    //Solving the maze
    public boolean solve() {
        ArrayList<Cell> adjs = null;                    //adjacencies of the current cell
        LinkedList<Cell> stack = new LinkedList<>();    //initiating a stack
        Cell curCell = this.entry;                      //starting at  the entry of the maze

        while (!completed) {    //finding a solution
            curCell.visited = true;             //marking curCell as visited
            if (curCell == this.destination) {  //succeeded
                completed = succeeded = true;
            }
            else {
                adjs = getAdjs(curCell);        //getting adjacencies
                if (adjs.size() > 0) {
                    curCell = adjs.get(0);      //getting the next cell
                    for (int i = 1; i < adjs.size(); i++) { //save others to stack
                        stack.addFirst(adjs.get(i));
                    }
                }
                else if (!stack.isEmpty()) {        //no cell can be examined
                    curCell = stack.removeFirst();  //popping a cell from the stack
                }
                else {  //stack is empty: No solution, failed
                    completed = true;
                    succeeded = false;
                }
            }
        }
        return completed;
    } //solve()

    //Printing the maze
    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(cells[i][j].value);
            }
            System.out.println();
        }
    }

    //Getting the path of solution
    public LinkedList<Cell> getPath() {
        if (!succeeded) return null;
        LinkedList<Cell> path = new LinkedList<>();
        //Reverse traversing to get  the result path
        Cell cell = this.destination;
        while (cell != null) {
            path.addFirst(cell);
            cell = cell.previous;
        }
        return path;
    }

    public static void main(String[] args) {
        String filename = "maze01.txt";
        Maze maze = new Maze();
        maze.loadFromFile(filename);
        maze.print();
        maze.solve();
        if (maze.succeeded) {
            System.out.println("Result path: ");
            System.out.println(maze.getPath());
        }
        else {
            System.out.println("Failed");
        }
    }   //main()

}   //Maze class
