package multithreading_concurrency;

import java.util.*;
import java.util.Scanner;

import util.NthPrimeNumber;


public class DaemonUserThreads {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        Runnable printStatus = () -> {
            try {
                while (true) {
                    Thread.sleep(5000);
                    threads.forEach(thread -> System.out.print("Status " + thread.getState() + " "));
                }
            } catch (InterruptedException e) {
                System.out.println("Status Print Interrupted");
            }
        };
        Thread statusReporter = new Thread(printStatus);
        statusReporter.start();

        int n = 1;
        Scanner sc = new Scanner(System.in);
        while (n != 0) {
            System.out.println("I can tell You the nth prime number enter -- n ");
            n = sc.nextInt();
            if (n == 0) {
                statusReporter.interrupt();


                System.out.println("Waitng for all threads to complete there job");
                waitForThreads(threads);
                System.out.println("These many threads excuted " + threads.size());


                break;
            }
            ;
            int finalN = n;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    int num = NthPrimeNumber.findnthPrimeNumber(finalN);
                    System.out.println("Here it is -- " + num);
                }
            };
/**
 * user thread keeps working and do not let process end that's why we make it daemon here
 * if 0 enters then it should end rather waiting for  whatever answer is not yet received
 **/
            Thread thread = new Thread(run);
            threads.add(thread);
            thread.setDaemon(true);
            thread.start();


        }
    }

    /**
     * what if u want to wait for all threads to be ended before main threads get ended?
     * thread.join() comes into picture here.
     * it implements a condition called Barrier Synchronization.
     * Basically it stops the execution of next code befor current thread gets excuted.
     * it can be parameterized also and throws interrupted exception.
     *
     */

    public static void waitForThreads(List<Thread> threads)  {
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Thread got interrupted while waiting");
            }
        });

    }

    /**
     * there is no stop method for thread
     * we have interupt which ask thread to gracefully clean up and shutdown on its own or throw Interrupted Exception
     */


    /**
     * Concurrency VS Parallelism
     *Parallelism -- Running multiple programs at same time
     * Concurrency -- Multiple tasks are in progress at same time
     *
     * All depends on Scheduler
     */

    /** Common Race Condition Pattern
     *
     * Check Then Act
     * Read Modify Write
     *
     * **/
}
