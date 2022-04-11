public class ReEnterLockDemo {
    public synchronized void m1(){
        System.out.println("=========外层函数");
        m2();
    }

    public synchronized void m2(){
        System.out.println("=========中层函数");
        m3();
    }

    public synchronized void m3(){
        System.out.println("=========内层函数");

    }

    public static void main(String[] args) {
        new ReEnterLockDemo().m1();
    }
}
