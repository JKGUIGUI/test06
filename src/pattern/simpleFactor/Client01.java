package pattern.simpleFactor;

/**
 * 简单工厂
 */
public class Client01 {
    public static void main(String[] args) {
        Car c1 = CarFactory.create("奥迪");
        Car c2 = CarFactory.create("比亚迪");

        c1.run();
        c2.run();
    }
}
