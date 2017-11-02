import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread thread_a = new Thread(() -> {
            try {
                lock.lock();
                System.out.println("a lock");
                condition.await();
                //通知成功后打印
                System.out.println("a signal成功");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
                System.out.println("a unlock");
            }
        });

        Thread thread_b = new Thread(() -> {
            try {
                lock.lock();
                System.out.println("b lock");
                condition.await();
                //通知成功后打印
                System.out.println("b signal成功");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
                System.out.println("b unlock");
            }
        });

        thread_a.start();
        thread_b.start();

        try {
            Thread.sleep(3000);
            lock.lock();
            condition.signal();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
