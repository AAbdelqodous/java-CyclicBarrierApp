package zoo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ZooManager {
    public void removeLion(){
        System.out.println(Thread.currentThread().getName() + ", Removing lion");
    }

    public void cleanCage(){
        System.out.println(Thread.currentThread().getName() + ", Cleaning cage");
    }

    public void addLion(){
        System.out.println(Thread.currentThread().getName() + ", Adding lion");
    }

    public void performTasks(CyclicBarrier barrier1, CyclicBarrier barrier2){

        try {
            removeLion();
            barrier1.await();

            cleanCage();
            barrier2.await();

            addLion();
//            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

    }
}
