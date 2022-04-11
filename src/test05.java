public class test05 {
    static Object object = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    System.out.println(Thread.currentThread().getName()+"\t"+"-----come in");
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"\t"+"-----被唤醒");
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    object.notify();
                    System.out.println(Thread.currentThread().getName()+"\t"+"-----通知");
                }
            }
        },"B").start();
    }
}
