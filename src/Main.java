import java.util.concurrent.Semaphore;

public class Main {

    private static Thread[] threads;
    protected static final int ID_PREZENTA = 121;
    protected static volatile int i=0;
    protected static volatile Semaphore Sectiune_critica = new Semaphore(1);

    public static void main(String[] args) {
        threads =  new Thread[4];
        for(int j=0; j<threads.length; j++){
            threads[j] = new MyThread(j);
        }
        for(int j=0; j<threads.length; j++){
            threads[j].start();
        }
        for(int j=0; j<threads.length; j++){
            try {
                threads[j].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
