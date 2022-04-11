import java.util.ArrayList;
import java.util.List;

public class test01 {
    public static void main(String[] args) {
        List list = new ArrayList();

        Thread t1 = new Thread(new Producer(list),"生产者线程");
        Thread t2 = new Thread(new Consumer(list),"消费者线程");

        t1.start();
        t2.start();

    }
}
class Producer implements Runnable{

    //仓库
    private List list;

    public Producer(List list){
        this.list = list;
    }
    @Override
    public void run() {
        while(true){
            synchronized (list) {
                if (list.size() > 0) { //仓库不为空，则满（假设仓库容量为1）
                    try {
                        list.wait(); //线程进入等待状态，释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(list.size());
                Object obj = new Object();
                list.add(obj);
                System.out.println(Thread.currentThread().getName()+"--->"+obj);
                list.notify();

            }
        }
    }
}

//消费线程
class Consumer implements Runnable{

    private List list;

    public Consumer(List list){
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                if (list.size() == 0) { //仓库为空
                    try {
                        list.wait();  //线程进入等待，释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(list.size());
                Object obj = list.remove(0);
                System.out.println(Thread.currentThread().getName() + "--->" + obj);
                list.notify(); //唤醒wait线程，但没有释放锁，只有循环结束才会释放锁

            }

        }
    }
}
