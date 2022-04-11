import java.util.concurrent.*;

/**
 * 自定义线程池
 */
public class MyThreadPoolDemo02 {
    public static void main(String[] args) {
      ExecutorService threadPool = new ThreadPoolExecutor(2,
              5,
              1L,
              TimeUnit.SECONDS,
              new LinkedBlockingDeque<Runnable>(3),
              Executors.defaultThreadFactory(),
              new ThreadPoolExecutor.DiscardPolicy());
            try {
                for (int i = 1;i<=20;i++) {
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


