package recursion_NQueens;

public class QueenPosition {
    int x, y;
    public QueenPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Checking whether 2 queen  positions are valid or not
    public boolean valid(QueenPosition p) {
        int dx = this.x - p.x;
        dx = (dx < 0) ? -dx : dx;
        int dy = this.y - p.y;
        dy = (dy < 0) ? -dy : dy;
        return !(dx == 0 || dy == 0 || dx == dy);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
