import java.util.ArrayList;
import java.util.List;

public class test11 {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        ThreadC threadC = new ThreadC(list);
        ThreadD threadD = new ThreadD(list);
        threadC.start();

        threadD.start();
    }
}

class ThreadC extends Thread{
    private List<Integer> list;

    public ThreadC(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i =0;i<10;i++){
            list.add(i);
            System.out.println("添加了" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadD extends Thread{
    private List<Integer> list;

    public ThreadD(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true){
            if (list.size()!=5){
                System.out.println("==5, 线程b准备退出了");
            }
        }
    }
}
