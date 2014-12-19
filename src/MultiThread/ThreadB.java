package MultiThread;

/**
 * Created by i843719 on 12/3/14.
 */
class ThreadB extends Thread{
    int total;
    //notify() wakes up the first thread that called wait() on the same object.
    @Override
    public void run(){
        synchronized(this){
            for(int i=0; i<100 ; i++){
                total += i;
            }
            notify();
        }
    }
}