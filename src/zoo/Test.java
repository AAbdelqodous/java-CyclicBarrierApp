package zoo;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);

        ZooManager manager = new ZooManager();

        CyclicBarrier barrier1 = new CyclicBarrier(4);

        CyclicBarrier barrier2 = new CyclicBarrier(4, () -> System.out.println("Cleaning cage done.."));

        try {
            for (int i = 0; i < 4; i++) {
                service.submit(() -> manager.performTasks(barrier1, barrier2));
            }
        }finally {
            if (service != null)
                service.shutdown();
        }
    }
}
