package backtrack_gen;

import java.util.Collection;

public class IntMinMaxSet {
    private int minVal = 0;
    private int maxVal = 0;
    int curVal = minVal - 1;
    //Constructors
    //Create a set using min and max value
    public IntMinMaxSet(int min, int max) {
        if (min > max) {
            int t = min;
            min = max;
            max = t;
        }
        this.minVal = min;
        this.maxVal = max;
        curVal = minVal - 1;
    }
    //Create a set from a collection
    public IntMinMaxSet(Collection collection) {
        this.minVal = 0;
        this.maxVal = collection.size() - 1;
        curVal = minVal - 1;
    }

    public boolean hasNext() {
        return curVal + 1 <= maxVal;
    }

    //getting the next value in the set
    public int nextValue() {
        if (this == null) throw new RuntimeException("The set is empty.");
        if (this.isLastValue()) throw new RuntimeException("End of the set.");
        return ++curVal;
    }
    //checking whether the curVal is the last value or not
    public boolean isLastValue() {
        return curVal == maxVal;
    }
    //reset the set to the original state
    public void reset() {
        curVal = minVal - 1;
    }
}
