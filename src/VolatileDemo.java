import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemo {
    public static void main(String[] args) {
        Mydata mydata = new Mydata();
        for (int i=1;i<=20;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=1;j<=1000;j++){
                        mydata.addPlusPlus();
                        mydata.addMyAtomic();
                    }
                }
            },String.valueOf(i)).start();
        }

        //需要等待上面20个线程全部计算完成后，再用main线程取得最终的结果值
        while (Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+"\t int type,finally number value:"+ mydata.number);
        System.out.println(Thread.currentThread().getName()+"\t AtomicInteger type,finally number value:"+ mydata.atomicInteger);
    }
}

class Mydata{
    volatile int number = 0;

    public void addTO60(){
        this.number = 60;
    }

    public void addPlusPlus(){
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }
}
