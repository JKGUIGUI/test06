import java.util.ArrayList;
import java.util.List;

public class test10 {
    private List<String> list = new ArrayList<String>();
    public void add() {
        list.add("elements");
    }
    public int size() {
        return list.size();
    }

 }

 class ThreadA extends Thread {
    private test10 list;
    public ThreadA(test10 list) {
        super();
        this.list = list;
    }
    @Override
   public void run() {
                  try {
                          for (int i = 0; i < 10; i++) {
                              Thread.sleep(1000);
                              list.add();
                              System.out.println("添加了" + (i + 1) + "个元素");
                              Thread.sleep(1000);
                          }
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                  }
    }
 }


 class ThreadB extends Thread {
    private test10 list;
    public ThreadB(test10 list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        try {
           while (true) {
                if (list.size() == 5) {
                    System.out.println("==5, 线程b准备退出了");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 }
 class Test {
    public static void main(String[] args) {
        test10 service = new test10();
        ThreadA a = new ThreadA(service);
        ThreadB b = new ThreadB(service);
        a.setName("A");
        b.setName("B");

        b.start();
        a.start();
    }
 }

