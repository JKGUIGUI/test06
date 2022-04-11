package pattern;

/**
 * 静态内部类（懒加载）
 */
public class SingletonDemo3 {

    private static class SingletonClassinstance{
        private static final SingletonDemo3 instance = new SingletonDemo3();
    }
    public static SingletonDemo3 getInstance(){
        return SingletonClassinstance.instance;

    }
    private SingletonDemo3(){}


}
