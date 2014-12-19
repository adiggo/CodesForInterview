package MultiThread;

/**
 * Created by i843719 on 12/3/14.
 */
public class HelloThread extends Thread {

    public void run() {
        System.out.println("Hello from a thread!");
        int res = 0;
        for (int i = 0; i <= 100; i++){
            res += i;
        }
        System.out.println(res);
        notify();
    }

    public static void main(String args[]) throws InterruptedException {
        Thread a = new HelloThread();
        a.start();
        synchronized (a) {
            a.wait();
        }
        //(new HelloThread()).start();
        System.out.println("Hello");
    }

}