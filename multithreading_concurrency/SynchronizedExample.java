package multithreading_concurrency;

/**
 *             synchronized Block
 *
 * synchronized(objectRef(Lock)){
 *     // piece of code which u want to be executed by one thread at a time
 * }
 *
 * so if thread wants to execute the code it accuires the monitor lock
 * if it gets it executes the code and return lock at time of exiting the block
 */
public class SynchronizedExample {
    public static void main(String[] args) {
        Counter counter = new Counter();
        new Thread(counter,"One").start();
        new Thread(counter,"Two").start();
        new Thread(counter,"Three").start();
        new Thread(counter,"Four").start();
    }
}


class Counter implements  Runnable{

    int i =0 ;

    @Override
    public void run() {
        synchronized (this){

            i++;
            System.out.println("Current Thread" + Thread.currentThread().getName() + "  increamented val  "+ i);
            i--;
            System.out.println("Current Thread" + Thread.currentThread().getName() + "  decreamented val  "+ i);
        }

    }
}
