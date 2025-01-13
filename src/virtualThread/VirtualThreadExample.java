package virtualThread;

public class VirtualThreadExample {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            Long threadId = Thread.currentThread().threadId();

            for(int i=0; i<10; i++) {
                System.out.println(threadId + " Index: " + i);
            }
        };

        // Example 1: Create and start virtual thread
        Thread vThread1 = Thread.ofVirtual().start(runnable);

        // Example 2: Create but do not start virtual thread
        Thread vThreadUnstarted = Thread.ofVirtual().unstarted(runnable);

        vThreadUnstarted.start();

        // Example 3: How to join a virtual thread
        try {
            vThread1.join();
            vThreadUnstarted.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
