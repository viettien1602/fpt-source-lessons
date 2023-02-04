package stk_que.QDemo;

import java.util.LinkedList;    //queue for paying

public class Accountant implements Runnable {
    LinkedList<String> queue;   //queue for paying requests
    int duty;                   //number invoices per working session
    int count = 0;              //number of processed invoices
    //Create an accountant with a duty and pre-defined queue
    public Accountant(int duty, LinkedList<String> queue) {
        this.duty = duty;
        this.queue = queue;
    }
    //Activity for processing buying requests --> printing invoices
    @Override
    public void run() {
        while (count < duty) {
            try {
                if (!queue.isEmpty()) {         //there are still invoices
                    count++;
                    String info = "Invoice " + count + "/" + duty +
                            ": " + queue.removeFirst();
                    System.out.println(info);   //printing 1 invoice
                }
                //The duty completed, accountant stops working
                if (count == duty) Thread.currentThread().yield();
                else Thread.currentThread().sleep(500);     //pause 0.5 sec
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
