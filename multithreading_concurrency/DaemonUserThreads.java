package multithreading_concurrency;

import java.util.Scanner;

import util.NthPrimeNumber;


public class DaemonUserThreads {

        public static void main(String[] args) {
            int n =1;
            Scanner sc = new Scanner(System.in);
            while (n!=0) {
                System.out.println("I can tell You the nth prime number enter -- n ");
                n = sc.nextInt();
                if (n == 0) break;
                int finalN = n;
                Runnable run = new Runnable() {
                    @Override
                    public void run() {
                        int num = NthPrimeNumber.findnthPrimeNumber(finalN);
                        System.out.println("Here it is -- "+ num);
                    }
                };
/**
 * user thread keeps working and do not let process end that's why we make it daemon here
 * if 0 enters then it should end rather waiting for  whatever answer is not yet received
 **/
                Thread thread = new Thread(run);
                thread.setDaemon(true);
                thread.start();
            }
        }
    }


