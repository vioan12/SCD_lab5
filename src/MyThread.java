import java.util.concurrent.Semaphore;

/**
 * Created by Ioan on 08.01.2018.
 */
public class MyThread extends Thread{

    private int id;
    private static volatile Semaphore Sectiune_critica;
    MyThread(int valueofid){
        this.id = valueofid;
    }
    public void run(){
        while (Main.i<Main.ID_PREZENTA){
            Sectiune_critica.acquireUninterruptibly(1);
            //BEGIN - Sectiune critica
            Main.i++;
            System.out.println("Threadul "+id+" am incrementat i cu 1");
            //END - Sectiune critica
            Sectiune_critica.release(1);
        }
    }
}
