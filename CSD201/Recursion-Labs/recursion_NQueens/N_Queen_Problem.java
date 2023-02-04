package recursion_NQueens;

import  java.util.ArrayList;

public class N_Queen_Problem {
    int size, nQueens;
    ArrayList<QueenPosition> positions = null; //chessboard
    ArrayList<QueenPosition> solution;
    boolean solved = false;
    boolean succeeded = false;

    public N_Queen_Problem(int size, int nQueens) {
        this.size = size;
        this.nQueens = nQueens;
        //setup chessboard
        positions = new ArrayList<>();
        int i, j;
        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                positions.add(new QueenPosition(i, j));
            }
        }
    }

    //Checking a position (pos) is valid for the index position
    public boolean reverseValid(QueenPosition pos, int index) {
        if (index == 0) return true;
        for (int i = index - 1; i >= 0; i--) {
            QueenPosition p = solution.get(i);
            if (!pos.valid(p)) return false;
        }
        return true;
    }

    //Recursion approach for solving the n_queens problem
    private void recursiveSolve(int index) {
        if (solved) return;
        int i, j;
        //Choose a position for the index queen
        for (i = 0; i < positions.size() && !solved; i++) {
            //Remove positions from the index
            j = solution.size() - 1;
            while (j >= index) solution.remove(j--);
            QueenPosition pos = positions.get(i);
            if (reverseValid(pos, index)) {
                solution.add(pos);
                if (index == nQueens - 1) {
                    solved = succeeded = true;
                }
                else recursiveSolve(index + 1);
            }
        }
    }

    private void recursiveSolve() {
        solved = succeeded = false;
        if (this.size < this.nQueens) solved = true;
        else {
            solution = new ArrayList<>(); //Initiate solution
            recursiveSolve(0);
        }
    }

    //Test
    public static void main(String[] args) {
        int size = 8;
        int nQueens = 8;
        N_Queen_Problem problem = new N_Queen_Problem(size, nQueens);
        problem.recursiveSolve();
        if (problem.solved) {
            if (problem.succeeded) {
                System.out.println("A solution: ");
                System.out.println(problem.solution);
            }
            else {
                System.out.println("No solution.");
            }
        }
        else System.out.println("Not solved yet.");
    }
}
