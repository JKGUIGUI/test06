
    public class test04 {

        public static void sync(String tips) {
            synchronized (test04.class) {
                System.out.println(tips);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }

        public static void main(String[] args) throws InterruptedException {
            while (true) {
                new Thread(() -> sync("线程1")).start();
                // Thread.sleep(100);
                new Thread(() -> sync("线程2")).start();
                //  Thread.sleep(100);
                new Thread(() -> sync("线程3")).start();
                //  Thread.sleep(100);
                new Thread(() -> sync("线程4")).start();

            }
        }
    }

