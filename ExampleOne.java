
// diff ways of running a thread and runnable interface




public class ExampleOne {
    public static void main(String[] args) {
        //TODO:how inner classes effects in java program ??
        class  MyRunnable implements Runnable {
            @Override
            public void run() {

            }
        }

        MyRunnable runnable = new MyRunnable() {
            @Override
            public void run() {
                System.out.println("Hii I  am my custom Runnable");
            }
        };
        //the thread class internally implements the Runnable interface
        Thread thread = new Thread( runnable);


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("another way of creating a thread");
            }
        });

        // lamda interface is basically implementing the runnable interface
        Thread thread2 = new Thread(()-> System.out.println("hello lambda way of creating thread"));


        class MyThread extends  Thread{
            @Override
            public void run() {
                System.out.println("hello another way of thread -- but a bad way? bcoz Thread class is like" +
                        "a infrastructure around Runnable don't change the way it works other wise it can " +
                        "cause issue let it it's job");
            }

        }

        MyThread thread3 = new MyThread();

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
