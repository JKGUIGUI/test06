import sun.security.krb5.internal.Ticket;

import java.util.concurrent.locks.Lock;

public class ReentrantLock {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();

        new Thread(()->{for (int i=1;i<40;i++) ticket.sale();},"A").start();
        new Thread(()->{for (int i=1;i<40;i++) ticket.sale();},"B").start();
        new Thread(()->{for (int i=1;i<40;i++) ticket.sale();},"C").start();
    }
}

/**
 * Lock步骤：
 * 1、new ReentrantLock()
 * 2、lock.lock() 加锁
 * 3、finally代码块中解锁  lock.unlock()
 */
class Ticket2{
    private int number = 30;

    Lock lock = new java.util.concurrent.locks.ReentrantLock();

    public void sale(){
        lock.lock(); //加锁

        try {

            //业务代码
            if (number > 0){
                System.out.println(Thread.currentThread().getName()+"卖出了"+
                        (number--)+"票，剩余："+number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock(); //解锁
        }

    }
}
