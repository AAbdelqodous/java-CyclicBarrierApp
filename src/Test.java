import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);

        CyclicBarrier barrier = new CyclicBarrier(3);
        service.submit(new CyclicBarrierTask(barrier ));
        service.submit(new CyclicBarrierTask(barrier ));
        service.submit(new CyclicBarrierTask(barrier ));

        Thread.sleep(2000);

        service.close();
    }
}
