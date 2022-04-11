public class test02 {
    static Object object = new Object();

    public static void main(String[] args) {
        Object object = new Object();
        Thread thread1 = new Thread(new AA(object),"AA");
        Thread thread2 = new Thread(new BB(object),"BB");

        thread1.start();
        thread2.start();

    }
}

class AA implements Runnable{
    Object object = new Object();

    public AA(Object object) {
        this.object = object;
    }

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
}

class BB implements Runnable{
    Object object = new Object();

    public BB(Object object) {
        this.object = object;
    }

    @Override
    public void run() {

            synchronized (object){
                object.notify();
                System.out.println(Thread.currentThread().getName()+"\t"+"-----通知");
            }

    }
}
