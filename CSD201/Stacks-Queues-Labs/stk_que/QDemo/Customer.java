package stk_que.QDemo;

import java.util.LinkedList;    //queue for paying
import java.util.Random;        //for getting a randomized integer

public class Customer extends Thread {
    //for randomize money number
    static Random rand = new Random(System.currentTimeMillis());
    long delay;     //millisec for delay after each purchase
    LinkedList<String> queue;
    Thread acc;     //acc must exist before a customer can buy products
    //Create a customer
    public Customer(String custName, long delay, Thread acc, LinkedList<String> queue) {
        super(custName);
        this.delay = delay;
        this.acc = acc;
        this.queue = queue;
    }

    //Activity for buying
    @Override
    public void run() {
        while (acc.isAlive()) {     //accountant is working
            try {
                //preparing an invoice
                int price = 100 + rand.nextInt(100);   //at least 100$
                String msg = this.getName() + ", " + price + "$";
                //Sending a request to the queue for paying
                queue.addLast(msg); //wait for invoice
                //If acc stopped working, customer stops buying
                if (!acc.isAlive()) this.yield();   //Yield CPU
                //Else customer delays a duration before next request
                else this.sleep(delay);
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }
    }
}
