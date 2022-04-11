import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 第四种使用Java多线程的方式
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
       // ExecutorService threadPool = Executors.newFixedThreadPool(5); //一池5个处理线程
       // ExecutorService threadPool = Executors.newSingleThreadExecutor();//一池1个处理线程
        ExecutorService threadPool = Executors.newCachedThreadPool(); //一池多个处理线程

        //模拟10个用户办理业务，每个用户就是一个来自外部的请求线程
        try {
            for (int i = 1;i<=10;i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
           //     TimeUnit.MILLISECONDS.sleep(200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
