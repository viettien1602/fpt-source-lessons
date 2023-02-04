package llpkg;

public class MySortedLL {
    LL_Element head; //reference to the beginning of the list
    LL_Element tail; //reference to the end of the list

    //Default constructor: Initialize an empty list
    public MySortedLL() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    //Determine the ceiling of x in the list
    //x = 7, List: 1 2 3 4 5 8 9 -> return reference of 8 --> O(n/2)
    public LL_Element ceiling(Comparable x) {
        LL_Element t = head;
        while (t != null && t.data.compareTo(x) < 0) {
            t = t.next;
        }
        return t;
    }

    public LL_Element search(Comparable x) {
        LL_Element result = ceiling(x);
        if (result == null) return null;
        return (result.data.compareTo(x) == 0) ? result : null;
    }

    //add data x to the sorted LL
    public LL_Element add(Comparable x) {
        LL_Element newEle = new LL_Element(x);
        LL_Element after = ceiling(x);

        if (head == null) head = tail = newEle;
        else if (after == null) {
            newEle.next = null;
            newEle.previous = tail;
            tail.next = newEle;
            tail = newEle;
        }
        else if (after == head) {
            newEle.next = head;
            newEle.previous = null;
            head.previous = newEle;
            head = newEle;
        }
        else {
            LL_Element before = after.previous;
            newEle.next = after;
            newEle.previous = before;
            after.previous = newEle;
            before.next = newEle;
        }
        return newEle;
    }

    //Tool for add some data
    public void add(Comparable ... group) {
        for (Comparable data : group) {
            add(data);
        }
    }

    //Remove a specific valid reference --> O(1)
    private LL_Element remove(LL_Element remRef) {
        //If the list has only one element, then it will be removed
        if (remRef == head && head == tail) {
            head = tail = null;
            return remRef;
        }
        LL_Element before = remRef.previous;
        LL_Element after = remRef.next;
        if (remRef == head) {
            after.previous = null;
            head = after;
        }

        else if (remRef == tail) {
            before.next = null;
            tail = before;
        }
        else {
            before.next = after;
            after.previous = before;
        }
        return remRef;
    }

    public  LL_Element remove(Comparable x) {
        LL_Element remRef = search(x);
        if (remRef != null) remove(remRef);
        return remRef;
    }

    //***Inner class takes a role as a tool for traversing all data in the list
    private class Traverser implements MyIterator<Comparable> {
        //Data structure of traversor: curRef -> head -> ... -> tail
        LL_Element curRef;
        public Traverser() {
            curRef = new LL_Element(null);
            curRef.next = head;
        }

        @Override
        public boolean hasNext() {
            return (curRef.next != null);
        }
        @Override
        public Comparable next() {
            curRef = curRef.next;
            return curRef.data;
        }
    }

    //The MySortedLL class
    public MyIterator iterator() {
        if (head == null) return null;
        return new Traverser();
    }

}
