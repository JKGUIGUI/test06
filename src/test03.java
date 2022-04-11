public class test03 {
    static Object object = new Object();

    public static void main(String[] args) {
        Object object = new Object();
        Thread thread1 = new Thread(new CC(object),"CC");
        Thread thread2 = new Thread(new DD(object),"DD");

        thread1.start();
        thread2.start();

    }
}

class CC implements Runnable{
    Object object = new Object();

    public CC(Object object) {
        this.object = object;
    }

    @Override
    public void run() {


                System.out.println(Thread.currentThread().getName()+"\t"+"-----come in");

    }
}

class DD implements Runnable{
    Object object = new Object();

    public DD(Object object) {
        this.object = object;
    }

    @Override
    public void run() {

           // synchronized (object){
                System.out.println(Thread.currentThread().getName()+"\t"+"-----通知");
            //}

    }
}
